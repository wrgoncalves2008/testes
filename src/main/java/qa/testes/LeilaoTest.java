package qa.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import qa.testes.modelo.Lance;
import qa.testes.modelo.Leilao;
import qa.testes.modelo.Usuario;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
	   Leilao leilao = new Leilao("Macbook Pro 15");
	   Usuario steveJobs = new Usuario("Steve Jobs");
	   leilao.propoe(new Lance(steveJobs, 2000));
	   leilao.propoe(new Lance(steveJobs, 3000));
	   
	   assertEquals(1, leilao.getLances().size());
	   assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
	   Leilao leilao = new Leilao("Macbook Pro 15");
	   Usuario steveJobs = new Usuario("Steve Jobs");
	   Usuario billGates = new Usuario("Bill Gates");

	   leilao.propoe(new Lance(steveJobs, 2000));
	   leilao.propoe(new Lance(billGates, 3000));
	   leilao.propoe(new Lance(steveJobs, 4000));
	   leilao.propoe(new Lance(billGates, 5000));
	   leilao.propoe(new Lance(steveJobs, 6000));
	   leilao.propoe(new Lance(billGates, 7000));
	   leilao.propoe(new Lance(steveJobs, 8000));
	   leilao.propoe(new Lance(billGates, 9000));
	   leilao.propoe(new Lance(steveJobs, 10000));
	   leilao.propoe(new Lance(billGates, 11000));

	   // deve ser ignorado
	   leilao.propoe(new Lance(steveJobs, 12000));

	   assertEquals(10, leilao.getLances().size());
	   int ultimo = leilao.getLances().size() - 1;
	   Lance ultimoLance = leilao.getLances().get(ultimo);
	   assertEquals(11000.0, ultimoLance.getValor(), 0.00001);	   
	}
}

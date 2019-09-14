package qa.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import qa.testes.leilao.Avaliador;
import qa.testes.modelo.Lance;
import qa.testes.modelo.Leilao;
import qa.testes.modelo.Usuario;


public class AvaliadorTest {
	@Test   
	public void deveRetornarOMaiorEMenorLance() {
       Usuario joao = new Usuario("Joao");
       Usuario jose = new Usuario("José");
       Usuario maria = new Usuario("Maria");
       Leilao leilao = new Leilao("Playstation 3 Novo");
       leilao.propoe(new Lance(joao, 250.0));
       leilao.propoe(new Lance(jose, 300.0));
       leilao.propoe(new Lance(maria, 200.0));

       Avaliador leiloeiro = new Avaliador();
       leiloeiro.avalia(leilao);
       
       List<Lance> maiores = leiloeiro.getTresMaiores();
              
       // comparando a saida com o esperado
       assertEquals(3, maiores.size());
       assertEquals(300, maiores.get(0).getValor(), 0.00001);
       assertEquals(250, maiores.get(1).getValor(), 0.00001);
       assertEquals(200, maiores.get(2).getValor(), 0.00001);

       assertEquals(300, leiloeiro.getMaiorLance(), 0.00001);
       assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
   }
	
	@Test   
	public void testandoLancesEmOrdemCrescente() {
       Usuario joao = new Usuario("Joao");
       Usuario jose = new Usuario("José");
       Usuario maria = new Usuario("Maria");
       Usuario will = new Usuario("Will");
       
       Leilao leilao = new Leilao("Playstation 3 Novo");
       
       leilao.propoe(new Lance(joao, 10.0));
       leilao.propoe(new Lance(jose, 20.0));
       leilao.propoe(new Lance(maria, 30.0));
       leilao.propoe(new Lance(will, 40.0));
       

       Avaliador leiloeiro = new Avaliador();
       leiloeiro.avalia(leilao);

       // comparando a saida com o esperado
       List<Lance> maiores = leiloeiro.getTresMaiores();
       assertEquals(3, maiores.size());
       assertEquals(40, maiores.get(0).getValor(), 0.00001);
       assertEquals(30, maiores.get(1).getValor(), 0.00001);
       assertEquals(20, maiores.get(2).getValor(), 0.00001);

       assertEquals(40, leiloeiro.getMaiorLance(), 0.00001);
       assertEquals(10, leiloeiro.getMenorLance(), 0.00001);
       printValores("Ordem Crescente", leiloeiro.getTresMaiores() );
   }
	
	@Test   
	public void testandoLancesEmOrdemDeCrescente() {
       Usuario joao = new Usuario("Joao");
       Usuario jose = new Usuario("José");
       Usuario maria = new Usuario("Maria");
       Usuario will = new Usuario("Will");
       
       Leilao leilao = new Leilao("Playstation 3 Novo");
       
       leilao.propoe(new Lance(joao, 40.0));
       leilao.propoe(new Lance(jose, 30.0));
       leilao.propoe(new Lance(maria, 20.0));
       leilao.propoe(new Lance(will, 10.0));
       
       Avaliador leiloeiro = new Avaliador();
       leiloeiro.avalia(leilao);

       List<Lance> maiores = leiloeiro.getTresMaiores();       
       // comparando a saida com o esperado       
       assertEquals(3, maiores.size());
       assertEquals(40, maiores.get(0).getValor(), 0.00001);
       assertEquals(30, maiores.get(1).getValor(), 0.00001);
       assertEquals(20, maiores.get(2).getValor(), 0.00001);
       
       assertEquals(40, leiloeiro.getMaiorLance(), 0.00001);
       assertEquals(10, leiloeiro.getMenorLance(), 0.00001);
       printValores( "Ordem Decrescente",leiloeiro.getTresMaiores() );
   }
	
	@Test   
	public void testandoLanceUnico() {
       Usuario joao = new Usuario("Joao");
       Usuario jose = new Usuario("José");
       Usuario maria = new Usuario("Maria");
       Usuario will = new Usuario("Will");
       
       Leilao leilao = new Leilao("Playstation 3 Novo");
            
       leilao.propoe(new Lance(will, 10.0));       

       Avaliador leiloeiro = new Avaliador();
       leiloeiro.avalia(leilao);
       
       List<Lance> maiores = leiloeiro.getTresMaiores();
      
       // comparando a saida com o esperado
       
       assertEquals(10, maiores.get(0).getValor(), 0.00001);
       assertEquals(10, leiloeiro.getMaiorLance(), 0.00001);
       assertEquals(10, leiloeiro.getMenorLance(), 0.00001);  
       printValores("Lance Unico", leiloeiro.getTresMaiores() );
   }
	
	private void printValores(String amsg,  List<Lance> alista ) 
	{
		System.out.println(amsg);	
		for (Lance lance : alista) {
			System.out.println( lance.getValor() );			
		}
	}
}

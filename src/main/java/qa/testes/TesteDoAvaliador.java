package qa.testes;

import qa.testes.leilao.Avaliador;
import qa.testes.modelo.Lance;
import qa.testes.modelo.Leilao;
import qa.testes.modelo.Usuario;

public class TesteDoAvaliador {

	   public static void main(String[] args) {

	       Usuario joao = new Usuario("Joao");
	       Usuario jose = new Usuario("José");
	       Usuario maria = new Usuario("Maria");
	       Leilao leilao = new Leilao("Playstation 3 Novo");

	       leilao.propoe(new Lance(joao, 300.0));
	       leilao.propoe(new Lance(jose, 400.0));
	       leilao.propoe(new Lance(maria, 250.0));

	       Avaliador leiloeiro = new Avaliador();

	       leiloeiro.avalia(leilao);

	       System.out.println(leiloeiro.getMaiorLance()); // imprime 400.0
	   }
	}

package qa.testes.leilao;

import qa.testes.modelo.Lance;
import qa.testes.modelo.Leilao;

public class Avaliador {
	   private double maiorDeTodos = Double.NEGATIVE_INFINITY;

	   public void avalia(Leilao leilao) {
	       for (Lance lance : leilao.getLances()) {
	           if (lance.getValor() > maiorDeTodos) {
	               maiorDeTodos = lance.getValor();
	           }
	       }
	   }

	   public double getMaiorLance() {
	       return maiorDeTodos;
	   }
	}

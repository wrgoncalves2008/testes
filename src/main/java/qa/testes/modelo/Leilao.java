package qa.testes.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
    private String descricao;
    private List<Lance> lances;

    public Leilao(String descricao) {
   	 this.descricao = descricao;
   	 this.lances = new ArrayList<Lance>();
    }

    public void propoe(Lance lance) {
    	
    	if (qtdeLances(lance) < 5)
    	{
	     	if (lances.isEmpty() ||	!ultimoLanceDado().getUsuario().equals(lance.getUsuario())) 
	     	{
	     		lances.add(lance);
	     	}
    	}
    }
    
    private int qtdeLances( Lance lance )
    {    	
    	int contador = 0;
    	for (Lance l : lances)
    	{    		
    		if (l.getUsuario().equals(lance.getUsuario()))
    		{
    			contador++;
    		}
    	}    	
    	return contador;
    }

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

    public String getDescricao() {
   	 return descricao;
    }

    public List<Lance> getLances() {
   	 return Collections.unmodifiableList(lances);
    }
}

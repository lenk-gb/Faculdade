package br.com.advocacialca.model.bo;

import java.util.List;

import br.com.advocacialca.model.dao.DAOFactory;
import br.com.advocacialca.model.dao.interfaces.DespesaDAO;
import br.com.advocacialca.model.to.Despesa;

public class DespesaBO {
	
	public static List<Despesa> getDespesa(int numeroProcesso) throws Exception{
		
		DespesaDAO despesaDAO = DAOFactory.getDespesaDAO();
		
		return despesaDAO.getDespesas(numeroProcesso);
	}
	
	public static void deletarDespesa(int codigo) throws Exception{
		
		DespesaDAO despesaDAO = DAOFactory.getDespesaDAO();
		
		despesaDAO.deletarDespesa(codigo);
		
	}
	
	public static void inserirDespesa(Despesa despesa) throws Exception{
		
	/*	DespesaDAO despesaDAO = DAOFactory.getDespesaDAO();
		
		despesaDAO.inserirDespesa(despesa);*/
		
		DespesaDAO despesaDAO = DAOFactory.getDespesaDAO();
		//despesaDAO.inserirDespesa(despesa);

		Boolean validador = false ;

		//Valida o valor da despesa
		if (despesa.getValor() <= 0) {			
			validador = false;
			throw new Exception("O valor da despesa é menor ou igual a zero.");
			 
		} else {
			validador = true;
		}



		if (validador.equals(true)) {
			despesaDAO.inserirDespesa(despesa);	}
		
	}
	
	public static void alterarDespesa(Despesa despesa) throws Exception{
		
		DespesaDAO despesaDAO = DAOFactory.getDespesaDAO();
		
		despesaDAO.alterarDespesa(despesa);
		
	}
	
}


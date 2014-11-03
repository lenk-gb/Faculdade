package br.com.advocacialca.model.bo;

import java.util.List;

import br.com.advocacialca.model.dao.DAOFactory;
import br.com.advocacialca.model.dao.interfaces.TipoDespesaDAO;
import br.com.advocacialca.model.to.TipoDespesa;

public class TipoDespesaBO {
	
	public static List<TipoDespesa> buscarTiposDespesa() throws Exception{
		
		TipoDespesaDAO tipoDespesaDAO = DAOFactory.getTipoDespesaDAO();
		return tipoDespesaDAO.getTiposDespesa();
		
	}
	
}

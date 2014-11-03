package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException; 
import java.util.List;

import br.com.advocacialca.model.to.TipoDespesa;

public interface TipoDespesaDAO {
	
	/**
	 * 
	 * @return uma lista com os tipos de despesa
	 * @throws SQLException
	 */
	public List<TipoDespesa> getTiposDespesa() throws SQLException;
	
}

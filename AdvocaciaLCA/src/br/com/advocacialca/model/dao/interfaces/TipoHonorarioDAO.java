package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.advocacialca.model.to.TipoHonorario;

public interface TipoHonorarioDAO {
	
	/**
	 * 
	 * @return uma lista com os tipos de honorário (tarefa)
	 * @throws SQLException
	 */
	public List<TipoHonorario> getTiposHonorario() throws SQLException;
}

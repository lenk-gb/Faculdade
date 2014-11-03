package br.com.advocacialca.model.dao;

import br.com.advocacialca.model.dao.impl.OracleDespesaDAO;
import br.com.advocacialca.model.dao.impl.OracleHonorarioDAO;
import br.com.advocacialca.model.dao.impl.OracleProcessoDAO;
import br.com.advocacialca.model.dao.impl.OracleTipoDespesaDAO;
import br.com.advocacialca.model.dao.impl.OracleTipoHonorarioDAO;
import br.com.advocacialca.model.dao.interfaces.DespesaDAO;
import br.com.advocacialca.model.dao.interfaces.HonorarioDAO;
import br.com.advocacialca.model.dao.interfaces.ProcessoDAO;
import br.com.advocacialca.model.dao.interfaces.TipoDespesaDAO;
import br.com.advocacialca.model.dao.interfaces.TipoHonorarioDAO;

/**
 * Factory de DAOs.
 * @author SPK
 */
public abstract class DAOFactory {
	
	public static ProcessoDAO getProcessoDAO(){
		return new OracleProcessoDAO();
	}
	
	public static DespesaDAO getDespesaDAO(){
		return new OracleDespesaDAO();
	}
	
	public static TipoDespesaDAO getTipoDespesaDAO(){
		return new OracleTipoDespesaDAO();
	}
	
	public static HonorarioDAO getHonorarioDAO(){
		return new OracleHonorarioDAO();
	}
	
	public static TipoHonorarioDAO getTipoHonorarioDAO(){
		return new OracleTipoHonorarioDAO();
	}
	
}

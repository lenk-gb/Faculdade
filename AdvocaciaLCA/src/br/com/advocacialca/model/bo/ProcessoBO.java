package br.com.advocacialca.model.bo;

import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.model.dao.DAOFactory;
import br.com.advocacialca.model.dao.interfaces.ProcessoDAO;
import br.com.advocacialca.model.to.Processo;

public class ProcessoBO {
	
	public static List<Processo> getProcesso() throws Exception{
		
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();		
		return processoDAO.getProcesso();
		
	}
	
	public static List<Processo> getProcesso(int numeroProcesso) throws Exception{
		
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.getProcesso(numeroProcesso);
		
	}
	
	public static List<Processo> getProcesso(String nomeCliente) throws Exception{
		
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.getProcesso(nomeCliente);
		
	}
	
public static List<Processo> getProcesso(Calendar deData, Calendar ateData) throws Exception{
		
		ProcessoDAO processoDAO = DAOFactory.getProcessoDAO();
		return processoDAO.getProcesso(deData, ateData);
		
	}
	
}

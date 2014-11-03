package br.com.advocacialca.model.bo;

import java.util.List;

import br.com.advocacialca.model.dao.DAOFactory;
import br.com.advocacialca.model.dao.interfaces.HonorarioDAO;
import br.com.advocacialca.model.to.Honorario;

public class HonorarioBO {
	
	public static List<Honorario> getHonorarioList(int numeroProcesso) throws Exception{
		
		HonorarioDAO honorarioDAO = DAOFactory.getHonorarioDAO();
		return honorarioDAO.getHonorarioList(numeroProcesso);
	}

	public static void inserirHonorario(Honorario honorario) throws Exception {
		
		HonorarioDAO despesaDAO = DAOFactory.getHonorarioDAO();		
		despesaDAO.inserirHonorario(honorario);
		
	}
	
	public static void deletarHonorario(int codigo) throws Exception {
		
		HonorarioDAO despesaDAO = DAOFactory.getHonorarioDAO();		
		despesaDAO.deletarHonorario(codigo);
		
	}
	
	
}

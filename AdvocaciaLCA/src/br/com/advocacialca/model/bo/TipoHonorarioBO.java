package br.com.advocacialca.model.bo;

import java.util.List;

import br.com.advocacialca.model.dao.DAOFactory;
import br.com.advocacialca.model.dao.interfaces.TipoHonorarioDAO;
import br.com.advocacialca.model.to.TipoHonorario;

public class TipoHonorarioBO {
	
public static List<TipoHonorario> buscarTiposHonorario() throws Exception{
		
		TipoHonorarioDAO tipoHonorarioDAO = DAOFactory.getTipoHonorarioDAO();
		return tipoHonorarioDAO.getTiposHonorario();
		
	}
	
}

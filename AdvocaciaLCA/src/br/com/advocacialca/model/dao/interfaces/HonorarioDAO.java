package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.advocacialca.model.to.Honorario;

public interface HonorarioDAO {
	
	/**
	 * Seleciona todos os <code>Honorario</code> registrados no banco de dados
	 * @return retorna uam lista com todos os Honorários de acordo com número do processo
	 * @throws SQLException
	 */
	public List<Honorario> getHonorarioList(int numeroProcesso) throws SQLException;
	
	
	/**
	 * Irá inserir um Honorario na base de dados
	 * @return
	 * @throws SQLException
	 */
	public void inserirHonorario(Honorario honorario) throws SQLException;

	/**
	 * Irá deletar um Honorario na base de dados
	 * @return
	 * @throws SQLException
	 */
	public void deletarHonorario(int deletar) throws SQLException;

}

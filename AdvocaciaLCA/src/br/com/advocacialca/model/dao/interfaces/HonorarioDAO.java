package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.advocacialca.model.to.Honorario;

public interface HonorarioDAO {
	
	/**
	 * Seleciona todos os <code>Honorario</code> registrados no banco de dados
	 * @return retorna uam lista com todos os Honor�rios de acordo com n�mero do processo
	 * @throws SQLException
	 */
	public List<Honorario> getHonorarioList(int numeroProcesso) throws SQLException;
	
	
	/**
	 * Ir� inserir um Honorario na base de dados
	 * @return
	 * @throws SQLException
	 */
	public void inserirHonorario(Honorario honorario) throws SQLException;

	/**
	 * Ir� deletar um Honorario na base de dados
	 * @return
	 * @throws SQLException
	 */
	public void deletarHonorario(int deletar) throws SQLException;

}

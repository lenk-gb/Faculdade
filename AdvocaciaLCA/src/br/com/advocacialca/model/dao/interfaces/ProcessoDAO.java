package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.model.to.Processo;

/**
 * DAO do TO <code>Processo</code>
 * @author Lamarca
 *
 */
public interface ProcessoDAO {
	
	/**
	 * Seleciona todos os processos cadastrados no banco de dados
	 * @return uma lista de <code>Processo</code>
	 * @throws SQLException
	 */
	public List<Processo> getProcesso() throws SQLException;
	
	/**
	 * Seleciona todos os processos cadastrados no banco de dados através do filtro número do processo
	 * @param numeroProcesso numero do processo pelo o qual a lista deve ser filtradado
	 * @return uma lista de <code>Processo</code> com filtro <code>numeroProcesso</code>
	 * @throws SQLException
	 */
	public List<Processo> getProcesso(int numeroProcesso) throws SQLException;
	
	/**
	 * Seleciona todos os processos cadastrados no banco de dados através do filtro nome do Clinte
	 * @param nomeCliente nome do cliente pelo o qual a lista deve ser filtradado
	 * @return uma lista de <code>Processo</code> com filtro <code>nomeCliente</code>
	 * @throws SQLException
	 */
	public List<Processo> getProcesso(String nomeCliente) throws SQLException;

	public List<Processo> getProcesso(Calendar deData, Calendar ateData) throws SQLException;
}

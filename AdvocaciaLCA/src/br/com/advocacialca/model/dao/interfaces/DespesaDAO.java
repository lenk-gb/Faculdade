package br.com.advocacialca.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.advocacialca.model.to.Despesa;

public interface DespesaDAO {
	
	/**
	 * Seleciona todas as despesas relacionada um processo específico
	 * @param numeroProcesso numero do processo que fara o filtro para as despesas
	 * @return uma lista de <code>Despesa</code>
	 * @throws SQLException
	 */
	public List<Despesa> getDespesas(int numeroProcesso) throws SQLException;
	
	/**
	 * Seleciona uma <code>Despesa</code> especifica e apaga ela do banco de dados
	 * @param codigo número do lançamento da <code>Despesa</code> para fazer a exclusão 
	 * @throws SQLException
	 */
	public void deletarDespesa(int codigo) throws SQLException;
	
	/**
	 * Seleciona uma <code>Despesa</code> com os dados passado via servlet e inseri na base de dados
	 * @param despesa um objeto que representa <code>Despesa</code> com os calores a ser inseridos no banco de dados
	 * @throws SQLException
	 */
	public void inserirDespesa(Despesa despesa) throws SQLException;
	
	/**
	 * Seleciona uma <code>Despesa</code> com os dados passado via servlet e altera na base de dados
	 * @param despesa um objeto que representa <code>Despesa</code> com os calores a ser inseridos no banco de dados
	 * @throws SQLException
	 */
	public void alterarDespesa(Despesa despesa) throws SQLException; 
	
}

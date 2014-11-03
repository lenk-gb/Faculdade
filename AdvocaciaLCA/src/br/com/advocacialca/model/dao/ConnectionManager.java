package br.com.advocacialca.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe geranciadora de conexao com o banco de dados.
 * @author SPK
 */
public class ConnectionManager {
	
	//instancia(unica) a ser fornecida
	private static ConnectionManager connectionManager;
	
	public ConnectionManager() throws ClassNotFoundException {

		//
		//Registra o driver JDBC para o Oracle
		//
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	}
	
	public static ConnectionManager getInstance() throws SQLException{

		try{
		
			//verifica se existe uma instância ou não
			if (connectionManager == null) {
				connectionManager = new ConnectionManager();
			}
		
		}
		catch(ClassNotFoundException e){
			
			throw new SQLException("O Driver JDBC não foi encontrado!");
			
		}
		
		return connectionManager;
	}
	
	public Connection getConnection() throws SQLException {
		
		String usuario = "";
		String senha = "";
		
		String jdbcUrl = "";
		
		try{
		
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new SQLException("Erro ao abrir a conexão com banco de dados", e);

		}
		
	}
}

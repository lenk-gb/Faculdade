package br.com.advocacialca.model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.model.dao.ConnectionManager;
import br.com.advocacialca.model.dao.interfaces.ProcessoDAO;
import br.com.advocacialca.model.to.Advogado;
import br.com.advocacialca.model.to.Cliente;
import br.com.advocacialca.model.to.Processo;

public class OracleProcessoDAO implements ProcessoDAO {
	
	private static final String MSG_ERRO_ABRIR_CONEXAO  = "Erro ao conectar ou manipular o banco de dados!";
	private static final String MSG_ERRO_FECHAR_CONEXAO = "Erro ao fechar a conexao com o banco de dados!";
	
	private List<Processo> processoList = new ArrayList<Processo>();
	private Connection conn = null;
	
	@Override
	public List<Processo> getProcesso() throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT J.NR_PROCESSO, J.CD_CLIENTE, J.DS_PROCESSO, I.DS_RAZAO_SOCIAL, "
					+ "J.NR_SITUACAO, J.DT_ABERTURA, ADVOGADO, CODIGO "
					+ "FROM T_AM_SPK_PROCESSO J INNER JOIN T_AM_SPK_CLIENTE I "
					+ "ON (I.CD_PESSOA = J.CD_CLIENTE) INNER JOIN T_AM_SPK_PESSOA K "
					+ "ON (K.CD_PESSOA = I.CD_PESSOA), "
					+ "(SELECT A.CD_PESSOA AS CODIGO, K.NM_PESSOA AS ADVOGADO "
					+ "FROM T_AM_SPK_PESSOA K INNER JOIN T_AM_SPK_ADVOGADO A "
					+ "ON (K.CD_PESSOA = A.CD_PESSOA)) "
					+ "WHERE CODIGO = J.CD_ADVOGADO "
					+ "ORDER BY NR_PROCESSO ASC";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				Processo objProcesso = new Processo();
				
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getInt("CD_CLIENTE"));
				objCliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				
				Advogado objAdvogado = new Advogado();
				objAdvogado.setCodigo(rs.getInt("CODIGO"));
				objAdvogado.setNome(rs.getString("ADVOGADO"));
				
				objProcesso.setAdvogado(objAdvogado);
				objProcesso.setCliente(objCliente);
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				objProcesso.setSituacao(rs.getBoolean("NR_SITUACAO"));
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_ABERTURA");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objProcesso.setDataAbertura(c);
				
				processoList.add(objProcesso);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(MSG_ERRO_ABRIR_CONEXAO, e);
		} finally {
			
			if (conn != null) {
				try {

					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(MSG_ERRO_FECHAR_CONEXAO, e);
				}
			}
		}
		
		return processoList;
	}

	@Override
	public List<Processo> getProcesso(int numeroProcesso) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			String query = "SELECT J.NR_PROCESSO, J.CD_CLIENTE, J.DS_PROCESSO, I.DS_RAZAO_SOCIAL, "
					+ "J.NR_SITUACAO, J.DT_ABERTURA, ADVOGADO, CODIGO "
					+ "FROM T_AM_SPK_PROCESSO J INNER JOIN T_AM_SPK_CLIENTE I "
					+ "ON (I.CD_PESSOA = J.CD_CLIENTE) INNER JOIN T_AM_SPK_PESSOA K "
					+ "ON (K.CD_PESSOA = I.CD_PESSOA), "
					+ "(SELECT A.CD_PESSOA AS CODIGO, K.NM_PESSOA AS ADVOGADO "
					+ "FROM T_AM_SPK_PESSOA K INNER JOIN T_AM_SPK_ADVOGADO A "
					+ "ON (K.CD_PESSOA = A.CD_PESSOA)) "
					+ "WHERE CODIGO = J.CD_ADVOGADO "
					+ "AND J.NR_PROCESSO = ?";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			prepareStmt.setInt(1, numeroProcesso);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				Processo objProcesso = new Processo();
				
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getInt("CD_CLIENTE"));
				objCliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				
				Advogado objAdvogado = new Advogado();
				objAdvogado.setCodigo(rs.getInt("CODIGO"));
				objAdvogado.setNome(rs.getString("ADVOGADO"));
				
				objProcesso.setAdvogado(objAdvogado);
				objProcesso.setCliente(objCliente);
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				objProcesso.setSituacao(rs.getBoolean("NR_SITUACAO"));
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_ABERTURA");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objProcesso.setDataAbertura(c);
				
				processoList.add(objProcesso);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(MSG_ERRO_ABRIR_CONEXAO, e);
		} finally {
			
			if (conn != null) {
				try {

					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(MSG_ERRO_FECHAR_CONEXAO, e);
				}
			}
		}
		
		return processoList;
	}

	@Override
	public List<Processo> getProcesso(String nomeCliente) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT J.NR_PROCESSO, J.CD_CLIENTE, J.DS_PROCESSO, I.DS_RAZAO_SOCIAL, "
					+ "J.NR_SITUACAO, J.DT_ABERTURA, ADVOGADO, CODIGO "
					+ "FROM T_AM_SPK_PROCESSO J INNER JOIN T_AM_SPK_CLIENTE I "
					+ "ON (I.CD_PESSOA = J.CD_CLIENTE) INNER JOIN T_AM_SPK_PESSOA K "
					+ "ON (K.CD_PESSOA = I.CD_PESSOA), "
					+ "(SELECT A.CD_PESSOA AS CODIGO, K.NM_PESSOA AS ADVOGADO "
					+ "FROM T_AM_SPK_PESSOA K INNER JOIN T_AM_SPK_ADVOGADO A "
					+ "ON (K.CD_PESSOA = A.CD_PESSOA)) "
					+ "WHERE CODIGO = J.CD_ADVOGADO "
					+ "AND I.DS_RAZAO_SOCIAL LIKE '%"+nomeCliente+"%' "
					+ "ORDER BY NR_PROCESSO ASC";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				Processo objProcesso = new Processo();
				
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getInt("CD_CLIENTE"));
				objCliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				
				Advogado objAdvogado = new Advogado();
				objAdvogado.setCodigo(rs.getInt("CODIGO"));
				objAdvogado.setNome(rs.getString("ADVOGADO"));
				
				objProcesso.setAdvogado(objAdvogado);
				objProcesso.setCliente(objCliente);
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				objProcesso.setSituacao(rs.getBoolean("NR_SITUACAO"));
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_ABERTURA");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objProcesso.setDataAbertura(c);
				
				processoList.add(objProcesso);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(MSG_ERRO_ABRIR_CONEXAO, e);
		} finally {
			
			if (conn != null) {
				try {

					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(MSG_ERRO_FECHAR_CONEXAO, e);
				}
			}
		}
		
		return processoList;
	}

	@Override
	public List<Processo> getProcesso(Calendar deData, Calendar ateData) throws SQLException {

		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			String query = "SELECT J.NR_PROCESSO, J.CD_CLIENTE, J.DS_PROCESSO, I.DS_RAZAO_SOCIAL, "
					+ "J.NR_SITUACAO, J.DT_ABERTURA, ADVOGADO, CODIGO "
					+ "FROM T_AM_SPK_PROCESSO J INNER JOIN T_AM_SPK_CLIENTE I "
					+ "ON (I.CD_PESSOA = J.CD_CLIENTE) INNER JOIN T_AM_SPK_PESSOA K "
					+ "ON (K.CD_PESSOA = I.CD_PESSOA), "
					+ "(SELECT A.CD_PESSOA AS CODIGO, K.NM_PESSOA AS ADVOGADO "
					+ "FROM T_AM_SPK_PESSOA K INNER JOIN T_AM_SPK_ADVOGADO A "
					+ "ON (K.CD_PESSOA = A.CD_PESSOA)) "
					+ "WHERE CODIGO = J.CD_ADVOGADO "
					+ "AND J.DT_ABERTURA BETWEEN ? AND ?";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			Date d1 = new Date(deData.getTimeInMillis());
			Date d2 = new Date(ateData.getTimeInMillis());
			
			prepareStmt.setDate(1, d1);
			prepareStmt.setDate(2, d2);
			
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				Processo objProcesso = new Processo();
				
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Cliente objCliente = new Cliente();
				objCliente.setCodigo(rs.getInt("CD_CLIENTE"));
				objCliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				
				Advogado objAdvogado = new Advogado();
				objAdvogado.setCodigo(rs.getInt("CODIGO"));
				objAdvogado.setNome(rs.getString("ADVOGADO"));
				
				objProcesso.setAdvogado(objAdvogado);
				objProcesso.setCliente(objCliente);
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				objProcesso.setSituacao(rs.getBoolean("NR_SITUACAO"));
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_ABERTURA");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objProcesso.setDataAbertura(c);
				
				processoList.add(objProcesso);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(MSG_ERRO_ABRIR_CONEXAO, e);
		} finally {
			
			if (conn != null) {
				try {

					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException(MSG_ERRO_FECHAR_CONEXAO, e);
				}
			}
		}
		
		return processoList;
	}

}

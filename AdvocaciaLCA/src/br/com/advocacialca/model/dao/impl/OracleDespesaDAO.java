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
import br.com.advocacialca.model.dao.interfaces.DespesaDAO;
import br.com.advocacialca.model.to.Despesa;
import br.com.advocacialca.model.to.Processo;
import br.com.advocacialca.model.to.TipoDespesa;

public class OracleDespesaDAO implements DespesaDAO{
	
	private static final String MSG_ERRO_ABRIR_CONEXAO  = "Erro ao conectar ou manipular o banco de dados!";
	private static final String MSG_ERRO_FECHAR_CONEXAO = "Erro ao fechar a conexao com o banco de dados!";
	
	private Connection conn = null;
	
	@Override
	public List<Despesa> getDespesas(int numeroProcesso) throws SQLException {

		List<Despesa> listaDespesas = new ArrayList<Despesa>();

		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT B.CD_LANCAMENTO, B.NR_PROCESSO, B.CD_TIPO_DESPESA, C.DS_PROCESSO, A.DS_TIPO_DESPESA, B.DT_DESPESA, "
					+ "B.VL_DESPESA "
					+ "FROM T_AM_SPK_LANCA_DESPESA B INNER JOIN T_AM_SPK_TIPO_DESPESA A "
					+ "ON (A.CD_TIPO_DESPESA = B.CD_TIPO_DESPESA) INNER JOIN T_AM_SPK_PROCESSO C "
					+ "ON (C.NR_PROCESSO = B.NR_PROCESSO) "
					+ "WHERE B.NR_PROCESSO = ?";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			prepareStmt.setInt(1, numeroProcesso);
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {
				
				Despesa objDespesa = new Despesa();
				objDespesa.setCodigo(rs.getInt("CD_LANCAMENTO"));
				
				Processo objProcesso = new Processo();
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				objDespesa.setProcesso(objProcesso);
				
				TipoDespesa objTipoDespesa = new TipoDespesa();
				objTipoDespesa.setCodigo(rs.getInt("CD_TIPO_DESPESA"));
				objTipoDespesa.setDescricao(rs.getString("DS_TIPO_DESPESA"));
				objDespesa.setTipoDespesa(objTipoDespesa);
				
				objDespesa.setValor(rs.getDouble("VL_DESPESA"));
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_DESPESA");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objDespesa.setData(c);
				
				listaDespesas.add(objDespesa);
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
		
		return listaDespesas;
	}

	@Override
	public void deletarDespesa(int codigo) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "DELETE FROM T_AM_SPK_LANCA_DESPESA "
					+ "WHERE CD_LANCAMENTO = ? ";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			prepareStmt.setInt(1, codigo);
			prepareStmt.executeQuery();
			
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

	}

	@Override
	public void inserirDespesa(Despesa despesa) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "INSERT INTO T_AM_SPK_LANCA_DESPESA "
					+ "(CD_LANCAMENTO, CD_TIPO_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) "
					+ "VALUES (SQ_AM_LANCA_DESPESA.NEXTVAL, ?, ?, ?, ?, ?)";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			prepareStmt.setInt(1, despesa.getTipoDespesa().getCodigo());
			prepareStmt.setInt(2, despesa.getProcesso().getNumeroProcesso());
			
			Date data = new Date(despesa.getData().getTimeInMillis());			
			prepareStmt.setDate(3, data);
			prepareStmt.setDouble(4, despesa.getValor());
			prepareStmt.setString(5, despesa.getObservacao());
			
			prepareStmt.executeQuery();
			
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
		
	}

	@Override
	public void alterarDespesa(Despesa despesa) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "UPDATE T_AM_SPK_LANCA_DESPESA SET "
					+ "DT_DESPESA = ?, VL_DESPESA = ?, DS_OBSERVACAO = ? "
					+ "WHERE CD_LANCAMENTO = ?";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
		
			Date data = new Date(despesa.getData().getTimeInMillis());
			
			prepareStmt.setDate(1, data);
			prepareStmt.setDouble(2, despesa.getValor());
			prepareStmt.setString(3, despesa.getObservacao());
			prepareStmt.setInt(4, despesa.getCodigo());
			
			prepareStmt.executeQuery();
			
			
		}  catch (SQLException e) {
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
		
		
	}

}

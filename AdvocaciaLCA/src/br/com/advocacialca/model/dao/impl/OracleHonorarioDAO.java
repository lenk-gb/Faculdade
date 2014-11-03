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
import br.com.advocacialca.model.dao.interfaces.HonorarioDAO;
import br.com.advocacialca.model.to.Advogado;
import br.com.advocacialca.model.to.Honorario;
import br.com.advocacialca.model.to.Processo;
import br.com.advocacialca.model.to.TipoHonorario;

public class OracleHonorarioDAO implements HonorarioDAO {
	
	private static final String MSG_ERRO_ABRIR_CONEXAO  = "Erro ao conectar ou manipular o banco de dados!";
	private static final String MSG_ERRO_FECHAR_CONEXAO = "Erro ao fechar a conexao com o banco de dados!";
	
	private Connection conn = null;

	@Override
	public List<Honorario> getHonorarioList(int numeroProcesso) throws SQLException {
		
		List<Honorario> honorarioList = new ArrayList<Honorario>();
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT A.CD_LANCAMENTO, C.DS_TIPO_TAREFA, C.CD_TIPO_TAREFA, A.NR_PROCESSO, B.DS_PROCESSO, A.DT_HONORARIO, "
					+ "A.QT_HORA, A.DS_OBSERVACAO, ADVOGADO, CODIGO "
					+ "FROM T_AM_SPK_LANCA_HONORARIO A INNER JOIN T_AM_SPK_PROCESSO B "
					+ "ON (A.NR_PROCESSO = B.NR_PROCESSO) INNER JOIN T_AM_SPK_TIPO_TAREFA C "
					+ "ON (A.CD_TIPO_TAREFA = C.CD_TIPO_TAREFA), "
					+ "(SELECT A.CD_PESSOA AS CODIGO, K.NM_PESSOA AS ADVOGADO "
					+ "FROM T_AM_SPK_PESSOA K INNER JOIN T_AM_SPK_ADVOGADO A ON (K.CD_PESSOA = A.CD_PESSOA)) "
					+ "WHERE CODIGO = B.CD_ADVOGADO AND A.NR_PROCESSO = ? "
					+ "ORDER BY A.CD_LANCAMENTO";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			prepareStmt.setInt(1, numeroProcesso);
			ResultSet rs = prepareStmt.executeQuery();
			
			while(rs.next()) {
				
				Honorario objHonorario = new Honorario();
				objHonorario.setCodigo(rs.getInt("CD_LANCAMENTO"));
				
				TipoHonorario objTipoHonorario = new TipoHonorario();				
				objTipoHonorario.setDescricao(rs.getString("DS_TIPO_TAREFA"));
				objTipoHonorario.setCodigo(rs.getInt("CD_TIPO_TAREFA"));
				objHonorario.setTipoHonorario(objTipoHonorario);
				
				Processo objProcesso = new Processo();
				objProcesso.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				objProcesso.setDescricao(rs.getString("DS_PROCESSO"));
				
				Advogado objAdvogado = new Advogado();
				objAdvogado.setCodigo(rs.getInt("CODIGO"));
				objAdvogado.setNome(rs.getString("ADVOGADO"));
				
				objProcesso.setAdvogado(objAdvogado);
				
				objHonorario.setProcesso(objProcesso);
				
				//Setar data de abertura no Processo
				Date d = rs.getDate("DT_HONORARIO");				
				Calendar c = Calendar.getInstance();				
				c.setTime(d);
				objHonorario.setData(c);
				objHonorario.setQuantidadeHora(rs.getDouble("QT_HORA"));
				objHonorario.setObservacao(rs.getString("DS_OBSERVACAO"));
				
				honorarioList.add(objHonorario);				
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
		
		return honorarioList;
	}

	@Override
	public void inserirHonorario(Honorario honorario) throws SQLException {


		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "INSERT INTO T_AM_SPK_LANCA_HONORARIO "
					+ "(CD_LANCAMENTO, CD_TIPO_TAREFA, NR_PROCESSO, DT_HONORARIO, QT_HORA, DS_OBSERVACAO) "
					+ "VALUES (SQ_AM_LANCA_HONORARIO.NEXTVAL, ?, ?, ?, ?, ?)";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			prepareStmt.setInt(1, honorario.getTipoHonorario().getCodigo());
			prepareStmt.setInt(2, honorario.getProcesso().getNumeroProcesso());
			
			Date data = new Date (honorario.getData().getTimeInMillis());			
			prepareStmt.setDate(3, data);
			prepareStmt.setDouble(4, honorario.getQuantidadeHora());
			prepareStmt.setString(5, honorario.getObservacao());
			
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
	public void deletarHonorario(int codigo) throws SQLException {
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "DELETE FROM T_AM_SPK_LANCA_HONORARIO WHERE CD_LANCAMENTO = ?";
			
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

}

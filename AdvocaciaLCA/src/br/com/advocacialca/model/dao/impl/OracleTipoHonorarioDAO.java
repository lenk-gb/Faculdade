package br.com.advocacialca.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.model.dao.ConnectionManager;
import br.com.advocacialca.model.dao.interfaces.TipoHonorarioDAO;
import br.com.advocacialca.model.to.TipoHonorario;

public class OracleTipoHonorarioDAO implements TipoHonorarioDAO {
	
	private static final String MSG_ERRO_ABRIR_CONEXAO  = "Erro ao conectar ou manipular o banco de dados!";
	private static final String MSG_ERRO_FECHAR_CONEXAO = "Erro ao fechar a conexao com o banco de dados!";
	
	@Override
	public List<TipoHonorario> getTiposHonorario() throws SQLException {

		List<TipoHonorario> tiposHonorarioList = new ArrayList<TipoHonorario>();
		Connection conn = null;
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT CD_TIPO_TAREFA, DS_TIPO_TAREFA FROM T_AM_SPK_TIPO_TAREFA ORDER BY CD_TIPO_TAREFA ASC";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				TipoHonorario objTipoHonorario = new TipoHonorario();
				
				objTipoHonorario.setCodigo(rs.getInt("CD_TIPO_TAREFA"));
				objTipoHonorario.setDescricao(rs.getString("DS_TIPO_TAREFA"));
				
				tiposHonorarioList.add(objTipoHonorario);
				
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
		
		return tiposHonorarioList;
	}

}

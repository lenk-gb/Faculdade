package br.com.advocacialca.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.model.dao.ConnectionManager;
import br.com.advocacialca.model.dao.interfaces.TipoDespesaDAO;
import br.com.advocacialca.model.to.TipoDespesa;

public class OracleTipoDespesaDAO implements TipoDespesaDAO {
	
	private static final String MSG_ERRO_ABRIR_CONEXAO  = "Erro ao conectar ou manipular o banco de dados!";
	private static final String MSG_ERRO_FECHAR_CONEXAO = "Erro ao fechar a conexao com o banco de dados!";

	@Override
	public List<TipoDespesa> getTiposDespesa() throws SQLException {

		List<TipoDespesa> tiposDespesaList = new ArrayList<TipoDespesa>();
		Connection conn = null;
		
		
		try {
			
			conn = ConnectionManager.getInstance().getConnection();
			
			String query = "SELECT CD_TIPO_DESPESA, DS_TIPO_DESPESA FROM T_AM_SPK_TIPO_DESPESA ORDER BY CD_TIPO_DESPESA ASC";
			
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			
			ResultSet rs = prepareStmt.executeQuery();
			
			while (rs.next()) {

				TipoDespesa objTipoDespesa = new TipoDespesa();
				
				objTipoDespesa.setCodigo(rs.getInt("CD_TIPO_DESPESA"));
				objTipoDespesa.setDescricao(rs.getString("DS_TIPO_DESPESA"));
				
				tiposDespesaList.add(objTipoDespesa);
				
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
		
		return tiposDespesaList;
	}

}

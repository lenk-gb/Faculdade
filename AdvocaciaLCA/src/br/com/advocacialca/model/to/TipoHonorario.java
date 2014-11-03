package br.com.advocacialca.model.to;

import java.io.Serializable;

/**
 * Classe representa <code>Tipo Tarefa</code> especificada no banco de dados
 */
public class TipoHonorario implements Serializable {

	private static final long serialVersionUID = -838374936107098897L;
	
	private int codigo;
	private String descricao;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

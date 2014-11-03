package br.com.advocacialca.model.to;

import java.io.Serializable;

/**
 * classe representa um Tipo de despesa 
 */
public class TipoDespesa implements Serializable{
	
	private static final long serialVersionUID = 937978288977007138L;
	
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

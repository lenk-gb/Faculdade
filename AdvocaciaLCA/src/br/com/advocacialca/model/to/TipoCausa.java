package br.com.advocacialca.model.to;

import java.io.Serializable;

/**
 * Classe representa o tipo da causa
 * @author SPK
 *
 */
public class TipoCausa implements Serializable{

	private static final long serialVersionUID = 7788457904667215030L;
	
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

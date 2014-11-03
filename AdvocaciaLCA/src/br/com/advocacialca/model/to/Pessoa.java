package br.com.advocacialca.model.to;

import java.io.Serializable;

/**
 * Classe representa uma pessoa
 * @author SPK
 */
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -2026830481749786375L;
	
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}

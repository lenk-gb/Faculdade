package br.com.advocacialca.model.to;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe representa um Processo
 * @author SPK
 */
public class Processo implements Serializable{

	private static final long serialVersionUID = -5014068051887574208L;
	
	private int numeroProcesso;
	private Cliente cliente;
	private Advogado advogado;
	private int tipoCausa;
	private int forum;
	private String descricao;
	private Calendar dataAbertura;
	private Calendar dataFechamento;
	private int diaVencimentoPagamento;
	private boolean resultadoCausa;
	private String observacao;
	private boolean situacao;
	
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Advogado getAdvogado() {
		return advogado;
	}
	
	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	
	public int getTipoCausa() {
		return tipoCausa;
	}
	
	public void setTipoCausa(int tipoCausa) {
		this.tipoCausa = tipoCausa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public Calendar getDataFechamento() {
		return dataFechamento;
	}
	
	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	public int getDiaVencimentoPagamento() {
		return diaVencimentoPagamento;
	}
	
	public void setDiaVencimentoPagamento(int diaVencimentoPagamento) {
		this.diaVencimentoPagamento = diaVencimentoPagamento;
	}
	
	public boolean getResultadoCausa() {
		return resultadoCausa;
	}
	
	public void setResultadoCausa(boolean resultadoCausa) {
		this.resultadoCausa = resultadoCausa;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public boolean getSituacao() {
		return situacao;
	}
	
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public int getForum() {
		return forum;
	}

	public void setForum(int forum) {
		this.forum = forum;
	}
}

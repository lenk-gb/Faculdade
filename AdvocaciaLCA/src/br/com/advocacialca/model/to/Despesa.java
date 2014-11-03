package br.com.advocacialca.model.to;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe representa uma <code>Despesa</code>
 */
public class Despesa implements Serializable {
	
	private static final long serialVersionUID = 3680783103002693834L;
	
	private int codigo;
	private Processo processo;
	private TipoDespesa tipoDespesa;
	private Calendar data;
	private double valor;
	private String observacao;

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Processo getProcesso() {
		return processo;
	}
	
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}

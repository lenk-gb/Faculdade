package br.com.advocacialca.model.to;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe representa um <code>Honorario</code>
 */
public class Honorario implements Serializable {

	private static final long serialVersionUID = -3265182996817472487L;
	
	private int codigo;
	private TipoHonorario tipoHonorario;
	private Processo processo;
	private Calendar data;
	private double quantidadeHora;
	private String observacao;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public TipoHonorario getTipoHonorario() {
		return tipoHonorario;
	}
	
	public void setTipoHonorario(TipoHonorario tipoHonorario) {
		this.tipoHonorario = tipoHonorario;
	}
	
	public Processo getProcesso() {
		return processo;
	}
	
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public double getQuantidadeHora() {
		return quantidadeHora;
	}
	
	public void setQuantidadeHora(double quantidadeHora) {
		this.quantidadeHora = quantidadeHora;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}

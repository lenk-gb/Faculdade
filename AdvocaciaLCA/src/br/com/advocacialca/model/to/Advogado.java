package br.com.advocacialca.model.to;

/**
 * Classe reprenseta um advogado
 * @author SPK
 */
public class Advogado extends Pessoa{
	
	private static final long serialVersionUID = 1678936322171169761L;
	
	private int oab;
	private int cpf;
	private String rg;
	private String email;
	private String password;
	
	public int getOab() {
		return oab;
	}
	
	public void setOab(int oab) {
		this.oab = oab;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

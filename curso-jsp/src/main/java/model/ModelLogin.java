package model;

import java.io.Serializable;

/*Essa classe sempre tem que implementar o serializable*/
public class ModelLogin implements Serializable{/*Parte de compilação das classes*/

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}

package org.agenciaDeEmprego.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true)
	private String login;
	private String senha;

	public Usuario() {
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", login='" + login + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}
}

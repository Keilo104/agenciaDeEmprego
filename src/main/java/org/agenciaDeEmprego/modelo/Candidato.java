package org.agenciaDeEmprego.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Candidato extends Usuario {

	private String cpf;
	private String nome;
	private LocalDate dataNasc;

	private int codigoCS;

	private String nomeCS;

	@OneToMany
	private List<Cargo> experiencia;

	public Candidato() {
	}

	public Candidato( String cpf, String nome, LocalDate dataNasc, int codigoCS, String nomeCS, List<Cargo> experiencia ) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.codigoCS = codigoCS;
		this.nomeCS = nomeCS;
		this.experiencia = experiencia;
	}

	public Candidato( String login, String senha, String cpf, String nome, LocalDate dataNasc, int codigoCS, String nomeCS, List<Cargo> experiencia ) {
		super( login, senha );
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.codigoCS = codigoCS;
		this.nomeCS = nomeCS;
		this.experiencia = experiencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getCodigoCS() {
		return codigoCS;
	}

	public void setCodigoCS(int codigoCS) {
		this.codigoCS = codigoCS;
	}

	public String getNomeCS() {
		return nomeCS;
	}

	public void setNomeCS(String nomeCS) {
		this.nomeCS = nomeCS;
	}

	public List<Cargo> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Cargo> experiencia) {
		this.experiencia = experiencia;
	}

	
	
	
}

package org.agenciaDeEmprego.modelo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Oferta {
	@Id
	@GeneratedValue
	int codigo;
	@OneToOne
	Cargo cargo;

	@OneToOne
	@Autowired
	Empresa empresa;
	
	private float salario;
	private int horas;

	public Oferta() {
	}

	public Oferta( int codigo, Cargo cargo, Empresa empresa, float salario, int horas) {
		super();
		this.codigo = codigo;
		this.cargo = cargo;
		this.empresa = empresa;
		this.salario = salario;
		this.horas = horas;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
}

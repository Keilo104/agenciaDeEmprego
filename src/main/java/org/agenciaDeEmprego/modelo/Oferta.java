package org.agenciaDeEmprego.modelo;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Oferta {
    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String codigo;

    @ManyToOne
    Cargo cargo;

    @ManyToMany
    List<Candidato> candidatos;

    @ManyToOne
    Empresa empresa;

    private float salario;
    private int horas;

    public Oferta() {
    }

    public Oferta( String codigo, Cargo cargo, Empresa empresa, float salario, int horas ) {
        super();
        this.codigo = codigo;
        this.cargo = cargo;
        this.empresa = empresa;
        this.salario = salario;
        this.horas = horas;
    }

    public Oferta( String codigo, float salario, int horas ) {
        this.codigo = codigo;
        this.salario = salario;
        this.horas = horas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo( String codigo ) {
        this.codigo = codigo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo( Cargo cargo ) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa( Empresa empresa ) {
        this.empresa = empresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario( float salario ) {
        this.salario = salario;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras( int horas ) {
        this.horas = horas;
    }
}

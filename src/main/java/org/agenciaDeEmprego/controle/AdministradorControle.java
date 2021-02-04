package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdministradorControle {

    private EmpresaRepositorio repositorio;

    @Autowired //injeção de dependência
    public AdministradorControle( EmpresaRepositorio empresaRepositorio ) {
        super();
        this.repositorio = repositorio;
    }
}

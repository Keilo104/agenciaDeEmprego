package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Usuario;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroCandidatoControle {

    private CandidatoRepositorio repositorio;

    @Autowired
    public CadastroCandidatoControle( CandidatoRepositorio repositorio ) {
        super();
        this.repositorio = repositorio;
    }

    @Transactional
    @RequestMapping(value = "cadastrarCandidato", method = RequestMethod.POST)
    public String cadastrar( Candidato candidato ) {
        repositorio.cadastrar( candidato );
        return "redirect:loginCandidato";
    }
}

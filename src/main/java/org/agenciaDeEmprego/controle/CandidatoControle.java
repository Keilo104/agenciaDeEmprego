package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class CandidatoControle {
    private CandidatoRepositorio repositorio;
    private OfertaRepositorio ofertasRepositorio;

    @Autowired
    public CandidatoControle( CandidatoRepositorio repositorio, OfertaRepositorio ofertaRepositorio ) {
        super();
        this.repositorio = repositorio;
        this.ofertasRepositorio = ofertaRepositorio;
    }

    @RequestMapping("candidato-pagina-inicial")
    public String inicioEmpresa( @SessionAttribute("candidato") Candidato candidato, Model model ) {
        model.addAttribute( "candidato", repositorio.getCandidato( candidato ) );
        model.addAttribute( "ofertas", ofertasRepositorio.buscarOfertas() );
        return "candidato/PaginaCandidato";
    }
}

package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class CandidatoControle {
    private CandidatoRepositorio repositorio;

    @Autowired
    public CandidatoControle( CandidatoRepositorio repositorio ) {
        super();
        this.repositorio = repositorio;
    }

    @RequestMapping("candidato-pagina-inicial")
    public String inicioEmpresa( @SessionAttribute("candidato") Candidato candidato, Model model ) {
        //model.addAttribute( "candidato", repositorio.getCandidato( candidato ) );
        return "candidato/PaginaCandidato";
    }

    @Transactional
    @RequestMapping(value = "cadastrarCandidato", method = RequestMethod.POST)
    public String cadastrar( Candidato candidato, Model model ) {
        if(repositorio.cadastrar( candidato )) {
            model.addAttribute("candidato", candidato);
            model.addAttribute("msg", "sucesso");
        } else {
            model.addAttribute("msg", "erro");
        }
        return "redirect:loginCandidato";
    }
}

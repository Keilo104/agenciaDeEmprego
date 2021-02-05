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
    private OfertaRepositorio ofertasRepositorio;
    private EmpresaRepositorio empresaRepositorio;
    private CargoRepositorio cargoRepositorio;

    @Autowired
    public CandidatoControle( CandidatoRepositorio repositorio, OfertaRepositorio ofertaRepositorio, EmpresaRepositorio empresaRepositorio, CargoRepositorio cargoRepositorio ) {
        super();
        this.repositorio = repositorio;
        this.ofertasRepositorio = ofertaRepositorio;
        this.cargoRepositorio = cargoRepositorio;
        this.empresaRepositorio = empresaRepositorio;
    }

    @RequestMapping("candidato-pagina-inicial")
    @Transactional
    public String inicioEmpresa( @SessionAttribute("candidato") Candidato candidato, Model model ) {
        model.addAttribute( "candidato", repositorio.getCandidato( candidato ) );
        model.addAttribute( "ofertas", ofertasRepositorio.buscarOfertas() );
        return "candidato/PaginaCandidato";
    }

    @RequestMapping("admin-pagina-inicial")
    public String inicioAdmin(Model model){
        model.addAttribute("empresas", empresaRepositorio.getAll());
        model.addAttribute("cargos", cargoRepositorio.buscarTodosCargos());
        return "admin/Admin";
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

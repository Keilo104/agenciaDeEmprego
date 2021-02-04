package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpresaControle {

    private EmpresaRepositorio repositorio;
    private OfertaRepositorio ofertaRepositorio;

    @Autowired
    public EmpresaControle( EmpresaRepositorio repositorio ) {
        super();
        this.repositorio = repositorio;
    }

    @RequestMapping("empresa-pagina-inicial")
    public String inicioEmpresa( Empresa empresa, Model model ) {
        model.addAttribute( "empresas", repositorio.getEmpresa( empresa.getId() ) );
        return "/empresa/PaginaEmpresa";
    }

    @Transactional
    @RequestMapping(value = "cadastrarEmpresa", method = RequestMethod.POST)
    public String cadastrarEmpresa( Empresa empresa, Model model) {
        repositorio.cadastrar( empresa );
        model.addAttribute("msg", "sucesso");
        return "redirect:loginEmpresa";
    }

    @Transactional
    @RequestMapping("excluir-empresa")
    public String excluirEmpresa( Integer codigo ) {
        Empresa empresa = repositorio.getEmpresa( codigo );
        repositorio.delete( empresa );
        return "redirect:pagina-inicial";
    }

    @RequestMapping("editar-empresa")
    public String editarEmpresa( Integer codigo, Model model ) {
        Empresa empresa = repositorio.getEmpresa( codigo );
        model.addAttribute( "empresa", empresa );
        return "editarempresaadmin";
    }
}

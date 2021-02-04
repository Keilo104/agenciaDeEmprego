package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpresaControle {

    private EmpresaRepositorio repositorio;

    @Autowired
    public EmpresaControle( EmpresaRepositorio repositorio ) {
        super();
        this.repositorio = repositorio;
    }

    @RequestMapping("admin-pagina-inicial")
    public String adminPagina( Model model ) {
        model.addAttribute( "empresas", repositorio.getAll() );
        return "admin";
    }

    @RequestMapping("candidato-pagina-inicial") // TODO
    public String candidatoPagina( Model model ) {
        model.addAttribute( "empresas", repositorio.getAll() );
        return "admin";
    }

    @Transactional
    @RequestMapping(value = "cadastrarEmpresa", method = RequestMethod.POST)
    public String cadastrarEmpresa( Empresa empresa ) {
        repositorio.cadastrar( empresa );
        return "redirect:loginEmpresa?msg=sucesso";
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

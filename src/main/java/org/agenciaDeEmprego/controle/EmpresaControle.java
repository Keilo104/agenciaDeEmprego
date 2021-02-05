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
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class EmpresaControle {

    private EmpresaRepositorio repositorio;
    private OfertaRepositorio ofertaRepositorio;

    @Autowired
    public EmpresaControle( EmpresaRepositorio repositorio, OfertaRepositorio ofertaRepositorio ) {
        super();
        this.repositorio = repositorio;
        this.ofertaRepositorio = ofertaRepositorio;
    }

    @RequestMapping("empresa-pagina-inicial")
    public String inicioEmpresa( @SessionAttribute("empresa") Empresa empresa, Model model ) {
        model.addAttribute( "ofertas", ofertaRepositorio.buscarOfertas() );
        return "/empresa/PaginaEmpresa";
    }

    @Transactional
    @RequestMapping(value = "cadastrarEmpresa", method = RequestMethod.POST)
    public String cadastrarEmpresa( Empresa empresa, Model model) {
        repositorio.cadastrar( empresa );
        model.addAttribute("msg", "sucesso");
        return "LoginEmpresa";
    }

    @Transactional
    @RequestMapping("excluir-empresa")
    public String excluirEmpresa( int codigo, Model model ) {
        Empresa empresa = repositorio.getEmpresa( codigo );
        repositorio.delete( empresa );
        model.addAttribute("empresas", repositorio.getAll());
        return "admin/Admin";
    }

    @RequestMapping("editar-empresa")
    public String editarEmpresa( Integer codigo, Model model ) {
        Empresa empresa = repositorio.getEmpresaComCodigo( codigo );
        model.addAttribute( "empresa", empresa );
        System.out.println(empresa.toString());
        return "admin/EditarEmpresaAdmin";
    }

//    public String atualizarEmpresa(){
//        repositorio.
//    }
}

package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfertaControle {
    private OfertaRepositorio repositorio;

    @Autowired
    public OfertaControle( OfertaRepositorio repositorio ) {
        this.repositorio = repositorio;
    }

    @RequestMapping("detalhes-oferta")
    public String detalhesOferta( int numero, Model model ) {
        model.addAttribute( "oferta", repositorio.getOferta( numero ) );
        return "empresa/DetalhesOferta";
    }

    @RequestMapping("excluir-oferta")
    public String excluirOferta( int numero ) {
        Oferta oferta = repositorio.getOferta( numero );
        repositorio.excluirOferta( oferta );
        return "empresa/DetalhesOferta";
    }

    @RequestMapping("pagina-cadastro-oferta")
    public String visaoCadastroOferta( int numero ) {
        return "empresa/CadastrarOferta";
    }

}

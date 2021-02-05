package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.agenciaDeEmprego.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OfertaControle {
    private OfertaRepositorio repositorio;
    private CargoRepositorio cargoRepositorio;

    @Autowired
    public OfertaControle( OfertaRepositorio repositorio, CargoRepositorio cargoRepositorio ) {
        this.repositorio = repositorio;
        this.cargoRepositorio = cargoRepositorio;
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
    public String visaoCadastroOferta( int numero, Model model ) {
        model.addAttribute( "cargos", cargoRepositorio.buscarCargos() );
        return "empresa/CadastrarOferta";
    }

    @RequestMapping(value = "cadastrar-oferta", method = RequestMethod.POST)
    public String cadastrarOferta( int cargo, Oferta oferta ) {
        oferta.setCargo( cargoRepositorio.buscarCargoPorCodigo( cargo ) );
        return "empresa/CadastrarOferta";
    }
}

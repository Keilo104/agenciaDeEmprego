package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.repositorio.CargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CargoControle {
    private CargoRepositorio repositorio;

    @Autowired
    public CargoControle( CargoRepositorio repositorio ) {
        this.repositorio = repositorio;
    }

    @RequestMapping("cadastrar-cargo")
    public String cadastrarCargo( Cargo cargo ) {
        repositorio.cadastrar( cargo );
        return "empresa/CadastrarCargo";
    }

    @RequestMapping("atualizar-cargo")
    public String atualizarCargo( Cargo cargo ) {
        repositorio.atualizarCargo( cargo );
        return "empresa/CadastrarCargo";
    }

    @RequestMapping("detalhes-cargo")
    public String buscarCargo( int numero ) {
        repositorio.buscarCargoPorCodigo( numero );
        return "empresa/CadastrarCargo";
    }

    @RequestMapping("excluir-cargo")
    public String excluirOferta( int numero ) {
        repositorio.excluirCargoPorId( numero );
        return "empresa/CadastrarCargo";
    }

    /*
    @RequestMapping("pagina-cadastro-cargo")
    public String visaoCadastroCargo( @SessionAttribute("empresa") Empresa empresa, Model model ) {
        model.addAttribute( "cargos", repositorio.buscarCargos( empresa ) );
        return "empresa/CadastrarCargo";
    }
    */
}

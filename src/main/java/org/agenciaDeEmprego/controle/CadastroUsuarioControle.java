package org.agenciaDeEmprego.controle;

import org.agenciaDeEmprego.modelo.Usuario;
import org.agenciaDeEmprego.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroUsuarioControle {

    private UsuarioRepositorio repositorio;

    @Autowired
    public CadastroUsuarioControle( UsuarioRepositorio repositorio ) {
        super();
        this.repositorio = repositorio;
    }

    @RequestMapping("cadastroForm")
    public String cadastroForm() {
        return "cadastrarCandidato";
    }

    @Transactional
    @RequestMapping(value = "cadastrar", method = RequestMethod.POST)
    public String cadastrar( Usuario usuario ) {
        repositorio.cadastrar( usuario );
        return "redirect:login";
    }
}

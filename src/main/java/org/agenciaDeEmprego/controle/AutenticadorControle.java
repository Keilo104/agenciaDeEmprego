package org.agenciaDeEmprego.controle;

import javax.servlet.http.HttpSession;

import org.agenciaDeEmprego.modelo.Usuario;
import org.agenciaDeEmprego.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutenticadorControle {

	private UsuarioRepositorio repositorio;

	@Autowired //injeção de dependência
	public AutenticadorControle(UsuarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@RequestMapping("login")
	public String loginForm() {
		//System.out.println("alo");
		return "login";
	}
	
	@RequestMapping(value = "autenticar", method = RequestMethod.POST)
	public String autenticar(Usuario usuario, HttpSession sessao) {
		if(repositorio.autenticar(usuario)) {
			sessao.setAttribute("usuario", usuario);
			if(usuario.getLogin().contains("admin")) {
				return "redirect:admin";
			} else {
				return "redirect:candidatoInicio";
			}
		}
		return "redirect:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "redirect:login";
	}

}

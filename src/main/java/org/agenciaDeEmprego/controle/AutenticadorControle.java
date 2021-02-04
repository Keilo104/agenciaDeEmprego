package org.agenciaDeEmprego.controle;

import javax.servlet.http.HttpSession;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Usuario;
import org.agenciaDeEmprego.repositorio.CandidatoRepositorio;
import org.agenciaDeEmprego.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutenticadorControle {

	private CandidatoRepositorio repositorioCandidato;

	@Autowired //injeção de dependência
	public AutenticadorControle(CandidatoRepositorio repositorio) {
		super();
		this.repositorioCandidato = repositorio;
	}
	
	@RequestMapping("loginCandidato")
	public String loginCandidato(@ModelAttribute("candidato") Candidato candidato, @ModelAttribute("msg") String msg) {
        //System.out.println(candidato.toString());
		return "loginCandidato";
	}

	@RequestMapping("loginEmpresa")
	public String loginEmpresa() {
		return "loginEmpresa";
	}
	
	@RequestMapping(value = "autenticarCandidato", method = RequestMethod.POST)
	public String autenticar(Candidato candidato, HttpSession sessao) {
		if(repositorioCandidato.autenticarCandidato(candidato)) {
			sessao.setAttribute("usuario", candidato);
			if(candidato.getLogin().contains("admin")) {
				return "redirect:admin-pagina-inicial";
			} else {
				return "redirect:candidato-pagina-inicial";
			}
		}
		return "loginCandidato";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "loginCandidato";
	}

}

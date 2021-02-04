package org.agenciaDeEmprego.acesso;

import javax.servlet.http.HttpSession;

import org.agenciaDeEmprego.modelo.Usuario;

public class Candidato implements Acesso {
	
	@Override
	public boolean autorizar(HttpSession sessao) {
		if(sessao == null) return false;
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if(usuario != null && !usuario.getLogin().equals("admin")) return true;
		return false;
	}

}

package org.agenciaDeEmprego.acesso;

import javax.servlet.http.HttpSession;

import org.agenciaDeEmprego.modelo.Usuario;

public class Logado implements Acesso {

	@Override
	public boolean autorizar(HttpSession sessao) {
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if((sessao != null) && (usuario != null)) return true;
		return false;
	}
	
	

}

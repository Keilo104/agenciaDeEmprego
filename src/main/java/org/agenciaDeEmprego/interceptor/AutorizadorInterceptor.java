package org.agenciaDeEmprego.interceptor;

import org.agenciaDeEmprego.acesso.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	private Hashtable<String, Acesso> acesso = new Hashtable<String, Acesso>();
	
	public AutorizadorInterceptor() {
		acesso.put("/lanchonetemaven/login", new Deslogado());
		acesso.put("/lanchonetemaven/autenticar", new Deslogado());
		acesso.put("/lanchonetemaven/logout", new Logado());
		acesso.put("/lanchonetemaven/cadastroForm", new Deslogado());
		acesso.put("/lanchonetemaven/cadastrar", new Deslogado());
		acesso.put("/lanchonetemaven/listarProdutosCliente", new Candidato());
		acesso.put("/lanchonetemaven/listarProdutosCarrinho", new Candidato());
		acesso.put("/lanchonetemaven/adicionarProdutocarrinho", new Candidato());
		acesso.put("/lanchonetemaven/removerProdutocarrinho", new Candidato());
		acesso.put("/lanchonetemaven/finalizarCompra", new Candidato());
		acesso.put("/lanchonetemaven/cadastrarProduto", new Admin());
		acesso.put("/lanchonetemaven/atualizarProduto", new Admin());
		acesso.put("/lanchonetemaven/excluirProduto", new Admin());
		acesso.put("/lanchonetemaven/alterarProduto", new Admin());
		acesso.put("/lanchonetemaven/listarProdutosAdmin", new Admin());
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		String uri = request.getRequestURI();
		if(acesso.get(uri).autorizar(request.getSession(false))) {
			return true;
		}
		
		response.sendRedirect("loginCandidato");
		return false;
	}

}

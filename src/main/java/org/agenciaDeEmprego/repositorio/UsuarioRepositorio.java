package org.agenciaDeEmprego.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenciaDeEmprego.modelo.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositorio {
	
	@PersistenceContext
	private EntityManager manager;

	public void cadastrar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public boolean autenticar(Usuario usuario) {
		Query query = manager.createQuery("select u from Usuario u where u.login = ?1 and senha = ?2");
		query.setParameter(1, usuario.getLogin()).setParameter(2, usuario.getSenha());
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public Usuario getUsuario(String login) {
		Query query = manager.createQuery("select u from Usuario u where u.login = ?1");
		query.setParameter(1, login);
		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	

}

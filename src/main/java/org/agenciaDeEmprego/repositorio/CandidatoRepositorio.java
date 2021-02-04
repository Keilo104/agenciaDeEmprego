package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Candidato;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CandidatoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;

	public void cadastrar(Candidato candidato) {
		manager.persist(candidato);
	}

	public boolean autenticarCandidato(Candidato usuario) {
		Query query = manager.createQuery("select u from Candidato u where u.login = ?1 and u.senha = ?2");
		query.setParameter(1, usuario.getLogin()).setParameter(2, usuario.getSenha());
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	public Candidato getCandidato(Candidato candidato) {
		try {
			return manager.find( Candidato.class, candidato );
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
}

package org.agenciaDeEmprego.repositorio;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Usuario;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class CandidatoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;

	public boolean cadastrar(Candidato candidato) {
		try {
			manager.persist(candidato);
			manager.flush();
			return true;
		} catch(EntityExistsException e) {
			return false;
		}
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

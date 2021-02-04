package org.agenciaDeEmprego.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenciaDeEmprego.modelo.Candidato;
import org.springframework.stereotype.Repository;

@Repository
public class CandidatoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;

	public void cadastrar(Candidato candidato) {
		manager.persist(candidato);
	}
	
	public Candidato getCandidato(String cpf) {
		Query query = manager.createQuery("select u from Candidato u where u.cpf = ?1");
		query.setParameter(1, cpf);
		try {
			return (Candidato) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	

}

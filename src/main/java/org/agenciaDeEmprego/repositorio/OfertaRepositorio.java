package org.agenciaDeEmprego.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenciaDeEmprego.modelo.Oferta;
import org.springframework.stereotype.Repository;

@Repository
public class OfertaRepositorio {
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Oferta oferta) {
		manager.persist(oferta);
	}
	
	public Oferta getOferta(int codigo) {
		Query query = manager.createQuery("select u from Oferta u where u.codigo = ?1");
		query.setParameter(1, codigo);
		try {
			return (Oferta) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}

package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Cargo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CargoRepositorio {

	@PersistenceContext
	private EntityManager manager;

	public CargoRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public void cadastrar(Cargo cargo) {
		manager.persist(cargo);
	}
	
	public Cargo getCargo(int codigo) {
		Query query = manager.createQuery("select u from Cargo u where u.codigo = ?1");
		query.setParameter(1, codigo);
		try {
			return (Cargo) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}

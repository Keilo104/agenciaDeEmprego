package org.agenciaDeEmprego.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenciaDeEmprego.modelo.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Empresa empresa) {
		manager.persist(empresa);
	}
	
	public Empresa getEmpresa(int codigo) {
		Query query = manager.createQuery("select u from Empresa u where u.codigo = ?1");
		query.setParameter(1, codigo);
		try {
			return (Empresa) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	

}

package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Oferta;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

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

	public Oferta buscarOfertas( int codigoEmpresa ) {
		Query query = manager.createQuery( "SELECT o FROM Oferta o WHERE o.empresa = ?1" );
		query.setParameter( 1, codigoEmpresa );
		try {
			return ( Oferta ) query.getResultList();
		} catch ( NoResultException e ) {
			return null;
		}
	}

	public List<Oferta> buscarOfertas() {
		TypedQuery<Oferta> query = manager.createQuery( "SELECT o FROM Oferta o", Oferta.class);
		try {
			return query.getResultList();
		} catch ( NoResultException e ) {
			return null;
		}
	}
}

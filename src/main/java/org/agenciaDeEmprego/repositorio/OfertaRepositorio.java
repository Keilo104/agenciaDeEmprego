package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Candidato;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class OfertaRepositorio {
	@PersistenceContext
	private EntityManager manager;

	public OfertaRepositorio() {
	}

	public void cadastrar(Oferta oferta) {
		manager.persist(oferta);
	}

	public void update(Oferta oferta) {
		manager.persist(oferta);
	}
	
	public Oferta getOferta(int codigo) {
		Query query = manager.createQuery("select u from Oferta u where u.id = ?1");
		query.setParameter(1, codigo);
		try {
			return (Oferta) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Oferta buscarCandidatosPelaOferta(int codigo) {
		Query query = manager.createQuery( "select * from Ofer oc \n" +
											"join candidato c on c.id = oc.candidatos_id\n" +
											"join oferta o on oc.oferta_id = o.id" );
		query.setParameter( 1, codigo );
		try {
			return ( Oferta ) query.getSingleResult();
		} catch ( NoResultException e ) {
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

	public List<Oferta> buscarOfertas(  ) {
		TypedQuery<Oferta> query = manager.createQuery( "SELECT o FROM Oferta o", Oferta.class );
		try {
			return query.getResultList();
		} catch ( NoResultException e ) {
			return null;
		}
	}

	public void excluirOferta( Oferta oferta ) {
		manager.remove( oferta );;
	}
}

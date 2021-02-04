package org.agenciaDeEmprego.repositorio;

import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CargoRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public void cadastrar( Cargo cargo ) {
        manager.persist( cargo );
    }

    public Cargo buscarCargoPorCodigo( int cargoCodigo ) {
        Query query = manager.createQuery( "SELECT c FROM Cargo c WHERE c.codigo = ?1" );
        query.setParameter( 1, cargoCodigo );
        try {
            return ( Cargo ) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }
    }

    public Cargo buscarCargo( Cargo cargo ) {
        return manager.find( Cargo.class, cargo );
    }

    public void excluirCargo( Cargo cargo ) {
        manager.remove( cargo );
    }

    public void excluirCargoPorId( int cargoId ) {
        manager.remove( cargoId );
    }

    public void atualizarCargo( Cargo cargo ) {
        manager.persist( cargo );
    }

    public List<Cargo> buscarCargos( Empresa empresa ) {
        Query query = manager.createQuery( "SELECT c FROM Cargo c WHERE c.empresa = ?1" );
        query.setParameter( 1, empresa.getId() );
        try {
            return query.getResultList();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cargo> buscarTodosCargos() {
        TypedQuery<Cargo> query = manager.createQuery( "SELECT c FROM Cargo c", Cargo.class);
        try {
            return query.getResultList();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}

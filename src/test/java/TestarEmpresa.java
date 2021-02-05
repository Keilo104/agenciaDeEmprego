import org.agenciaDeEmprego.modelo.Cargo;
import org.agenciaDeEmprego.modelo.Empresa;
import org.agenciaDeEmprego.modelo.Oferta;
import org.agenciaDeEmprego.repositorio.EmpresaRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestarEmpresa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Cargo cargo = new Cargo(12,"dev","morra trabalhando");
        manager.getTransaction().begin();
        manager.persist(cargo);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}

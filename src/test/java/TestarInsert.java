import org.agenciaDeEmprego.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestarInsert {

    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Usuario usuario = new Usuario( "admin", "123" );


        manager.getTransaction().begin();
        manager.persist( usuario );
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}

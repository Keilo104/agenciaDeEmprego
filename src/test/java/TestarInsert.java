import org.agenciaDeEmprego.modelo.Cargo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestarInsert {

    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Cargo cargo = new Cargo(1, "Dev", "Faz umas coisas legais");

        manager.getTransaction().begin();
        manager.persist( cargo );
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}

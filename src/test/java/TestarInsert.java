import org.agenciaDeEmprego.modelo.Cargo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestarInsert {

    public static void main( String[] args ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "agenciaDeEmpregodb" );
        EntityManager manager = factory.createEntityManager();

        Cargo cargo = new Cargo(1, "Dev", "Faz umas coisas legais");
        Cargo cargo2 = new Cargo(2, "QA", "Verifica coisas legais");
        Cargo cargo3 = new Cargo(3, "PO", "Fala com gente nem tanto legais");



        manager.getTransaction().begin();

        manager.persist( cargo2 );
        manager.persist( cargo3 );
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}

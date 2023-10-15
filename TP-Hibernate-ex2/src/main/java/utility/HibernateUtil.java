package utility;

import ma.projet.classes.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {


    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            return new MetadataSources(registry)
                    .addAnnotatedClass(Produit.class)
                    .addAnnotatedClass(Commande.class)
                    .addAnnotatedClass(LigneCommandeProduit.class)
                    .addAnnotatedClass(LigneCommandeProduitPK.class)
                    .addAnnotatedClass(Categorie.class)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

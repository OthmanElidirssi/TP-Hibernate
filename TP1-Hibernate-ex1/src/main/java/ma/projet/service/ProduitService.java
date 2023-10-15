package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    public SessionFactory getFactory() {
        return factory;
    }

    private SessionFactory factory;

    public ProduitService(SessionFactory factory){
        this.factory=factory;
    }
    @Override
    public boolean create(Produit o) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            session.save(o);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            System.out.println(error.getMessage());

            return false;
        }
        return true;
    }

    @Override
    public boolean update(Produit o) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            session.update(o);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            session.delete(o);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            return false;
        }
        return true;
    }

    @Override
    public Produit findById(int id) {
        Transaction tx = null;
        Produit produit=null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

           produit=session.get(Produit.class,id);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        Transaction tx = null;
        List<Produit> produits=new ArrayList<>();
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            produits=session.createQuery("From Produit",Produit.class).list();

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
        }
        return produits;
    }
}

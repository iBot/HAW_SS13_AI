package main.technik.persistenzManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;

/**
 *
 * User: milena
 *
 */
public class PersistenzManager  implements IPersistenzManager{


    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    public PersistenzManager(){

    }

    @Override
    public <T> T access(Class<T> cls, Serializable id) {

        Session session = InitSessionFactory.getInstance().getCurrentSession();
        Transaction tx = session.beginTransaction();
        T entity = (T)session.load(cls, id);
        tx.commit();

        return entity;

    }

//    @Override
//    public <T> List<T> getAll(Class<T> cls) {
//        Session session = InitSessionFactory.getInstance().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<T> list = session.createQuery("from "+cls.getName()).list();
//        tx.commit();
//
//        return list;
//    }

    @Override
    public <T> void create(T entity) {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();

    }

    @Override
    public <T> void delete(T entity) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        }
        catch(HibernateException e)
        {

        }
    }

    @Override
    public <T> void update(T entity) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }
        catch(HibernateException e)
        {

        }
    }

}

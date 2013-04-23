package main.technik.persistenzManager;

import org.hibernate.*;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;

/**
 *
 * User: milena
 *
 */
public class PersistenzManager  implements IPersistenzManager{


//    private static SessionFactory sessionFactory = null;
//    private static ServiceRegistry serviceRegistry = null;
    private static PersistenzManager persistenzManager = null;

    private PersistenzManager(){

    }

    @Override
    public <T> T access(Class<T> cls, Serializable id) {
        T entity = null;
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            entity = (T)session.get(cls, id);
            tx.commit();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
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
        try {
            SessionFactory sessionFactory = InitSessionFactory.getInstance();
            Session session = sessionFactory.getCurrentSession();
            System.out.print("Session: " +session == null);
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
    }

    @Override
    public <T> void delete(T entity) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
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
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
    }

    @Override
    public Query returnQuery(String queryString)
    {
        Session session = InitSessionFactory.getInstance().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(queryString);
        session.flush();
        session.clear();
        tx.commit();

        return query;
    }

    private static void exceptionHandling(Exception e)
    {
        try {
            Session session = InitSessionFactory.getInstance()
                    .getCurrentSession();
            if (session.getTransaction().isActive())
                session.getTransaction().rollback();
        } catch (HibernateException e1) {

        }
    }

    public static PersistenzManager getInstance()
    {
        if(persistenzManager == null)
            persistenzManager = new PersistenzManager();
        return persistenzManager;
    }


}

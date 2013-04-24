package main.technik.persistenzManager;

import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

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
    public <T> T access(Class<T> cls, Serializable id){
        T entity = null;
        try {
            Session session = InitSessionFactory.getInstance().openSession();
            Transaction tx = session.beginTransaction();
            entity = (T)session.get(cls, id);

            session.flush();
            tx.commit();
            session.close();
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
    public <T> void create(T entity){
        try {
            SessionFactory sessionFactory = InitSessionFactory.getInstance();
            Session session = sessionFactory.openSession();
            System.out.print("Session: " + session);
            Transaction tx = session.beginTransaction();
            session.save(entity);
            session.flush();
            tx.commit();
            session.close();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
    }

    @Override
    public <T> void delete(T entity){
        try {
            Session session = InitSessionFactory.getInstance().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(entity);

            session.flush();
            tx.commit();
            session.close();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
    }

    @Override
    public <T> void update(T entity){
        try {
            Session session = InitSessionFactory.getInstance().openSession();
            Transaction tx = session.beginTransaction();
            session.update(entity);

            session.flush();
            tx.commit();
            session.close();
        }
        catch (RuntimeException e) {
            exceptionHandling(e);
        }
    }

    @Override
    public <T> List<T> getAllByQuery(T entity, String query) {
        List<T> result = null;
//                try {
//            Session session = InitSessionFactory.getInstance().openSession();
//            Transaction tx = session.beginTransaction();
//            result = session.createQuery(query).list();
//
//            session.flush();
//            tx.commit();
//            session.close();
//        }
//        catch (RuntimeException e) {
//            exceptionHandling(e);
//        }
        return result;
    }

    @Override
    public Query returnQuery(String queryString)
    {
        Session session = InitSessionFactory.getInstance().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(queryString);
        session.flush();
        session.clear();
        tx.commit();
        session.close();
        return query;
    }

    private static void exceptionHandling(Exception e) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            if (session.getTransaction().isActive())
                session.getTransaction().rollback();
        } catch (HibernateException e1) {
            throw e1;
        }
    }

    public static PersistenzManager getInstance()
    {
        if(persistenzManager == null)
            persistenzManager = new PersistenzManager();
        return persistenzManager;
    }


}

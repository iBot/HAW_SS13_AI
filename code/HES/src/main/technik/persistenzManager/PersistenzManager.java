package main.technik.persistenzManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;
import java.util.List;

/**
 *
 * User: milena
 *
 */
public class PersistenzManager <T, I extends Serializable> implements IPersistenzManager{


    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    public PersistenzManager(){

    }

    @Override
    public T GetById(Class<T> cls, I id) {
       try {
           Session session = InitSessionFactory.getInstance().getCurrentSession();
           return (T)session.load(cls, id);
       }
       catch(HibernateException e)
       {
           return null;
       }
    }

    @Override
    public <T> List<T> GetAll(Class<T> cls) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            return session.createQuery("from "+cls.getName()).list();
        }
        catch(HibernateException e)
        {
            return null;
        }
    }

    @Override
    public <T> void Save(T entity) {
        try {
            Session session = InitSessionFactory.getInstance().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
        }
        catch(HibernateException e)
        {

        }
    }

    @Override
    public <T> void Delete(T entity) {
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
}

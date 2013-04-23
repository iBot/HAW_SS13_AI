package main.technik.persistenzManager;

import org.hibernate.Query;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 22.04.13
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public interface IPersistenzManager {

        /// Liefert eine Instanz des Typs T.
        <T> T access(Class<T> cls, Serializable id);

        /// Speichert einen Referenztyp in der Persistenz.
        <T> void create(T entity);

        /// Löscht eine gegebene Instanz aus der Persistenz.
        <T> void delete(T entity);

        /// Verändert einen Referenztyp in der Persistenz.
        <T> void update(T entity);

    Query returnQuery(String queryString);
}


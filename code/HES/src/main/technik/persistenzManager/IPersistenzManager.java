package main.technik.persistenzManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 22.04.13
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public interface IPersistenzManager {

        /// Liefert eine Instanz des Typs T.
        <T> T access(Class<T> cls, Serializable id) throws Exception;

        /// Speichert einen Referenztyp in der Persistenz.
        <T> void create(T entity) throws Exception;

        /// Löscht eine gegebene Instanz aus der Persistenz.
        <T> void delete(T entity) throws Exception;

        /// Verändert einen Referenztyp in der Persistenz.
        <T> void update(T entity) throws Exception;


    <T> T getUniqueResultByQuery(String query);

    <T> List<T> getAllByQuery(String query);
}


package main.technik.persistenzManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 22.04.13
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
public interface IPersistenzManager {
        /// <summary>
        /// Liefert eine Instanz des Typs T.
        /// </summary>
        /// <typeparam name="T">Beliebiger Referenztyp für den Typ der zu lesenden Instanz.</typeparam>
        /// <typeparam name="I">Beliebiger Wertetyp für den Schlüsseltyp.</typeparam>
        /// <param name="id">Schlüsselwert, für den die Instanz gelesen werden soll.</param>
        /// <param name="shouldLock">Angabe, ob die Instanz in der Persistenz gesperrt werden soll.</param>
        /// <returns></returns>
        <T, I> T GetById(Class<T> cls, I id);

        /// <summary>
        /// Liefert alle Instanzen eines gegebenen Typs zurück.
        /// </summary>
        /// <typeparam name="T">Beliebiger Referenztyp für den Typ der zu lesenden Instanzen.</typeparam>
        /// <returns></returns>
        <T> List<T> GetAll();

        /// <summary>
        /// Speichert einen Referenztyp in der Persistenz.
        /// </summary>
        /// <typeparam name="T">Typ der zu speichernden Instanz.</typeparam>
        /// <param name="entity">Zu speichernde Instanz.</param>
        /// <returns>Die gespeicherte Instanz.</returns>
        <T> void Save(T entity);

        /// <summary>
        /// Löscht eine gegebene Instanz aus der Persistenz.
        /// </summary>
        /// <typeparam name="T">Referenztyp der zu löschenden Instanz.</typeparam>
        /// <param name="entity">Die zu löschende Instanz.</param>
        <T> void Delete(T entity);
}


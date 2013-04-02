package hibernateExample;

import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 */
public class App {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static void main(String[] args) {
        setup();
        testeCRUDFunktionalitaet();
    }

    private static void testeCRUDFunktionalitaet() {

        List<Student> studentList = null;

        // Fetching saved data
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //Hole alle Studenten aus der Datenbank
            studentList = session.createQuery("from Student").list();


            // Committing the change in the database.
            session.flush();
            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        for (Student student : studentList) {

            // Berta wird umbenannt
            if (student.getName().equals("Berta")) {
                student.setName("Berta II");
            }
            System.out.println(student);
            //Stuenten bekommen eine zufällige Note
            student.getNotenkonto().setGesamtnote(Math.random() * 15);
            saveOrUpdate(student.getNotenkonto());
            saveOrUpdate(student);
        }

        // Neuen Kurs erzeugen
        Kurs meinKurs = new Kurs("K42", "How do I hibernate");
        saveOrUpdate(meinKurs);

        //Kurs verändern
        meinKurs.setTitle("Hibernate für Profis!");

        //Ein neues Buch erstellen
        Buch meinBuch = new Buch("B65", "Lesen für Analphabeten");
        Buch meinAnderesBuch = new Buch("B67", "Lesen hilft!");

        //Bücher zum Kurs hinzufügen
        meinKurs.addBuchempfehlung(meinBuch);
        meinKurs.addBuchempfehlung(meinAnderesBuch);

        //Kurs speichern, buch wir automatisch mitgespeichert
        saveOrUpdate(meinKurs);

        //Cesar aus der Datenbank laden
        Student cesar  = (Student)getOjectFromDatabaseByQuery("from Student where name = 'Cesar'");

        System.out.println(cesar.toString());

        //Cesar löschen
        delete(cesar);



        //Cesar erneut laden
        Student deletedCesar  = (Student)getOjectFromDatabaseByQuery("from Student where name = 'Cesar'");
        System.out.println(deletedCesar);


        //Folgende Test sollten Fehlschlagen!
//        Student anton  = (Student)getOjectFromDatabaseByQuery("from Student where name = 'Anton'");
//        System.out.println(anton.getNotenkonto());
//        Student dora = new Student("S99","Dora");
//        dora.setNotenkonto(anton.getNotenkonto());

//        Kurs dieserKursWirdMehrerenStudentenZugeordnet = new Kurs("K4711", "mehrfach belegter Kurs");
//        Student erna = new Student("S19","Erna");
//        erna.addKurs(dieserKursWirdMehrerenStudentenZugeordnet);
//        dora.addKurs(dieserKursWirdMehrerenStudentenZugeordnet);
//        saveOrUpdate(erna);
//        saveOrUpdate(dora);

    }

    private static Persistable getOjectFromDatabaseByQuery(String query){
        // Fetching saved data
        Session session = null;
        Transaction tx = null;

        Persistable result = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //Hole alle Studenten aus der Datenbank
            result = (Persistable)session.createQuery(query).uniqueResult();


            // Committing the change in the database.
            session.flush();
            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }


    private static void saveOrUpdate(Persistable object) {
        // Fetching saved data
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.saveOrUpdate(object);
            // Committing the change in the database.
            session.flush();
            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static void delete(Persistable object) {
        // Fetching saved data
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.delete(object);
            // Committing the change in the database.
            session.flush();
            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static void setup() {
        // Configure the session factory
        configureSessionFactory();

        Session session = null;
        Transaction tx = null;


        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();


            // Creating Student entity that will be save to the sqlite database
            Student student1 = new Student("S1", "Anton");
            Student student2 = new Student("S2", "Berta");
            Student student3 = new Student("S3", "Cesar");

            Kurs kurs1 = new Kurs("K1", "Mathe");
            Kurs kurs2 = new Kurs("K2", "Programmieren");
            Kurs kurs3 = new Kurs("K3", "Betriebssysteme");

            Buch buch1 = new Buch("B1", "Informatik Handbuch");
            Buch buch2 = new Buch("B2", "Programmieren für Einsteiger");
            Buch buch3 = new Buch("B3", "Das kleine 1 mal 1");

            Notenkonto notenkonto1 = new Notenkonto("N1");
            Notenkonto notenkonto2 = new Notenkonto("N2");
            Notenkonto notenkonto3 = new Notenkonto("N3");

            student1.addKurs(kurs1);
            student2.addKurs(kurs2);
            student3.addKurs(kurs3);

//            Set<Kurs> s1kurse = new HashSet<Kurs>();
//            s1kurse.add(kurs1);
//            s1kurse.add(kurs2);
//
//            student1.setKurse(s1kurse);
//
//            Set<Kurs> s2kurse = new HashSet<Kurs>();
//            s2kurse.add(kurs3);

            student1.setNotenkonto(notenkonto1);
            student2.setNotenkonto(notenkonto2);
            student3.setNotenkonto(notenkonto3);

            kurs1.addBuchempfehlung(buch1);
            kurs1.addBuchempfehlung(buch3);
            kurs2.addBuchempfehlung(buch2);
            kurs2.addBuchempfehlung(buch1);

            // Saving to the database
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(kurs1);
            session.save(kurs2);
            session.save(kurs3);
            session.save(buch1);
            session.save(buch2);
            session.save(buch3);
            session.save(notenkonto1);
            session.save(notenkonto2);
            session.save(notenkonto3);


            // Committing the change in the database.
            session.flush();
            tx.commit();

//            // Fetching saved data
//            List<Student> contactList = session.createQuery("from Student").list();
//
//            for (Student contact : contactList) {
//                System.out.println("Id: " + contact.getId() + " | Name:" + contact.getName());
//            }

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
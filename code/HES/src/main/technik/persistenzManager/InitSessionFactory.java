package main.technik.persistenzManager;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 22.04.13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class InitSessionFactory {
        /** The single instance of hibernate SessionFactory */
        private static org.hibernate.SessionFactory sessionFactory;
        private static ServiceRegistry serviceRegistry;
        private InitSessionFactory() {
        }
        static {
//            Configuration cfg = new
//                    Configuration();
//            cfg.configure("/data/Studium/AI/HAW_SS13_AI/code/HES/src/resources/hibernate/config/hibernate.cfg.xml");
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
//            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        public static SessionFactory getInstance() {
            if (sessionFactory == null){
                Configuration cfg = new
                        Configuration();
                cfg.configure();
                serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);

            }

            return sessionFactory;
        }

}

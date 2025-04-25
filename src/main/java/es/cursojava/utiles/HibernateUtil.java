package es.cursojava.utiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    // Patrón Singleton para la creación de la sesión de Hibernate
    // Se utiliza una única instancia de SessionFactory para toda la aplicación
    // y se reutiliza en cada llamada a getSession()
    private static Session session=null;

    private static Session generateSession (){ 
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return session;
    }

    // Patrón Singleton para obtener una única instancia de Session
    // Se crea la sesión al inicio y se reutiliza en cada llamada a getSession()
    // Si la sesión ya existe, se devuelve la misma instancia
    // Si no existe, se genera una nueva sesión y se devuelve
    // Esto es útil para evitar crear múltiples sesiones innecesarias y mejorar el rendimiento
    // de la aplicación
    // Además, se asegura que la sesión se cierre adecuadamente al finalizar su uso
    // y se evita la creación de múltiples instancias de SessionFactory, lo que puede ser costoso en términos de recursos y tiempo de ejecución.
    public static Session getSession() {
        if (session == null) {
            session = generateSession();
        }
       
        return session;
    }
}

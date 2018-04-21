package copiasCertificadas.persist.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	// private static final SessionFactory sessionUsers =
	// buildSessionFactoryUsers();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/*
	 * private static SessionFactory buildSessionFactoryUsers() { try { //
	 * Create the SessionFactory from hibernate.cfg.xml return new
	 * AnnotationConfiguration().configure("hibernateUsers.cfg.xml")
	 * .buildSessionFactory();
	 * 
	 * } catch (Throwable ex) {
	 * System.err.println("Initial SessionFactory creation failed." + ex); throw
	 * new ExceptionInInitializerError(ex); } }
	 */

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * public static SessionFactory getSessionusers() { return sessionUsers; }
	 */

}
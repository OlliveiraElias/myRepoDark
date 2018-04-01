package com.elias.util;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import com.elias.domain.*;

public final class HibernateUtil {
	
	private HibernateUtil(){}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(Estoque.class);
				ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(registry);
			} catch (Throwable e) {
				e.printStackTrace();
				throw new ExceptionInInitializerError();
			}
		}
		return sessionFactory;
	}

}

package com.elias.dao;

import java.lang.reflect.*;
import java.util.*;

import javax.persistence.criteria.*;

import org.hibernate.*;
import org.hibernate.query.Query;

import com.elias.domain.*;
import com.elias.util.*;

public class GenericDao<T extends AbstractDomain> {
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(T domain) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(t);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public List<T> listarTodos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(clazz);
			Root<T> root = criteria.from(clazz);
			criteria.select(root);
			Query<T> q = session.createQuery(criteria);
			List<T> list = q.getResultList();
			return list;
		} finally {
			session.close();
		}
	}
}

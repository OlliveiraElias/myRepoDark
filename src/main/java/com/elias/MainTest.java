package com.elias;

import org.hibernate.*;

import com.elias.dao.*;
import com.elias.domain.*;
import com.elias.util.*;

public class MainTest {
	
	public static void main(String[] args) {
		EstoqueDao estoqueDao = new EstoqueDao();
		for (Estoque e : estoqueDao.listarTodos()) {
			System.out.println(e.getDsProduto());
		}
		
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		s.close();
//		HibernateUtil.getSessionFactory().close();
	}

}

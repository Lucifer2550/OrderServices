package com.orderService.Repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orderService.Entity.OrderEntity;

@Repository
public class OrderRepository {

	@Autowired
	private SessionFactory sFact;
	
	public void processOrder(OrderEntity oe) {
		
		try {
			
			Session session = sFact.openSession();
			Transaction trans = session.beginTransaction();
			session.save(oe);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<OrderEntity> getAllOrders(){
		
		try {
			String hql="from OrderEntity";
			Session session = sFact.openSession();
			Query query = session.createQuery(hql);
			return query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;
	}
	
	public List<OrderEntity> getOrderById(int id){
		try {
			String hql="from OrderEntity WHERE altkey=:a";
			Session session = sFact.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("a", id);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;
	}
	
	public List<OrderEntity> getOrderByName(String name){
		try {
			String hql="from OrderEntity WHERE productName=:n";
			Session session = sFact.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("n", name);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;
	}
	
	public void deleteOrderById(int id) {
		
		try {
			
			String hql="delete from OrderEntity where altkey=:a";
			Session session = sFact.openSession();
			Transaction trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("a", id);
			query.executeUpdate();
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<OrderEntity> getProductsInRange(int lp,int hp){
		
		try {
			String hql="from OrderEntity WHERE totalPrice between : f and : s";
			Session session = sFact.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("f", lp);
			query.setParameter("s", hp);
			return  query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;
	}
	
	public void updatePriceByName(int price,String name) {
		try {
		String hqlQuery ="update OrderEntity set totalPrice=:p where productName=:n";
		Session session = sFact.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hqlQuery);
		query.setParameter("p", price);
		query.setParameter("n", name);
		query.executeUpdate();
		trans.commit();
		}catch(Exception e) {
			
		}
	}
	
	public List<OrderEntity> getOrdersSortedByName(OrderEntity oe){
		
		try {
			String hql="from OrderEntity";
			Session session = sFact.openSession();
			Query query = session.createQuery(hql);
			session.save(oe);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;
	}
	
}

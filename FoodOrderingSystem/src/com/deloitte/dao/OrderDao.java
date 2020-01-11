package com.deloitte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.deloitte.bean.OrderPage;
import com.deloitte.bean.Menu;

@Transactional
@Repository
public class OrderDao implements IOrderDao {

	@PersistenceContext
	EntityManager entityManager;
	Logger logger = Logger.getLogger(OrderDao.class);
//	private List<String> quantity;
	
	@Override
	public int confirmOrder(OrderPage ord) {
		System.out.println("DAO : "+ord);
		try{
		   entityManager.persist(ord);
		   logger.info("Saved Order : " + ord.getName());
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in inserting data "+e);
		}
		return 1;
	}

	@Override
	public List<Menu> getMenu() {
		TypedQuery<Menu> query = null;
		try{
			String sql = "SELECT list from Menu list order by foodId";
			query = entityManager.createQuery(sql, Menu.class);
		    logger.info("Fetching Menu ");
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in fetching data "+e);
		}
		return query.getResultList();
	}
	
	/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("stud");
			EntityManager em = emf.createEntityManager();
			Menu menu = em.find(Menu.class, quantity);
			OrderPage op = em.find(OrderPage.class, quantity);
			int quant = Integer.parseInt(op.getQuantity());
			menu.setQuantity(menu.getQuantity() - quant);*/
	
/*//	@Override
//	public List<Menu> updateMenu() {
//			Menu menu = em.find(Menu.class, id);
//			OrderPage op = em.find(OrderPage.class, quantity);
//			int quant = Integer.parseInt(op.getQuantity());
//			menu.setQuantity(menu.getQuantity() - quant);
//			return (List<Menu>) menu;
//	}
*/
	@Override
	public List<String> getFoods() {
		TypedQuery<String> query=null;
		try{
			String sql = "SELECT list.foodName from Menu list";
			query = entityManager.createQuery(sql, String.class);
			logger.info("Fetching foods " );			
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in loading category "+e);
		}
		return query.getResultList();
	}

	@Override
	public List<String> getQuantity() {
		TypedQuery<String> query=null;
		try{
			String sql = "SELECT list.quantity from Quantity list";
			query = entityManager.createQuery(sql, String.class);
			logger.info("Fetching quantity " );			
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in loading category "+e);
		}
		return query.getResultList();
	}

	@Override
	public int updateQuantity(String quantity, int id) {
		System.out.println("Id Got is " + id);
		Menu menu = entityManager.find(Menu.class, id);
		if(menu == null) {
			System.out.println("Null Found");
			return 1;
		}
		else {

			int quant = menu.getQuantity() - Integer.parseInt(quantity);
			if(quant>=0) {
			menu.setQuantity(quant);
			entityManager.merge(menu);}
			else {
				return -1;
			}
		}
		return 1;
	}

}

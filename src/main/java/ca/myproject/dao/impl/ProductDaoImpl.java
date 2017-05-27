package ca.myproject.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.myproject.dao.ProductDao;
import ca.myproject.model.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
        session.flush();
	}

	@Override
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public List<Product> listAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		 Query query= session.createQuery("from Product");
		 List<Product> productList = query.list();
		 session.flush();
		return productList;
	}

	@Override
	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();

	}

}

package ca.myproject.dao;

import java.util.List;

import ca.myproject.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	Product getProductById(String id);
	List<Product> listAllProduct();
	void deleteProduct(String id);
	

}

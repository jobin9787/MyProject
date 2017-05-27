package ca.myproject.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.myproject.model.Product;

public class ProductDaoOLD {

	private List <Product> productLis;

	public List<Product> getProductList() {
		
		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName("Guitars");
		product1.setProductCategory("Instrument");
		product1.setProductDescription("This is a Guitars");
		product1.setProductCondition("New");
		product1.setProductPrice(200.0);
		product1.setProductStatus("Active");
		product1.setProductUnitInStock(20);
		 productLis = new ArrayList<Product>();
		
		
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("Records");
		product2.setProductCategory("Records");
		product2.setProductCondition("New");
		product2.setProductDescription("This is a Records century");
		product2.setProductPrice(25.0);
		product2.setProductStatus("Active");
		product2.setProductUnitInStock(200);
		
		
		
		Product product3 = new Product();
		product3.setProductId("3");
		product3.setProductName("Speaker");
		product3.setProductCategory("Accessory");
		product3.setProductCondition("New");
		product3.setProductDescription("This is a folk shelf speaker");
		product3.setProductPrice(255.0);
		product3.setProductStatus("Active");
		product3.setProductUnitInStock(200);
		
		productLis.add(product1);
		productLis.add(product2);
		productLis.add(product3);
		return productLis;
	}

	public void setProductLis(List<Product> productLis) {
		this.productLis = productLis;
	}

	public Product getProductById(String productId)  throws IOException{

     for(Product prod : getProductList()){
    	 
    	 if (prod.getProductId().equals(productId)){
    		 return prod;
     }
		
     }
     throw new IOException("Product Not found");
	}
	
	
}

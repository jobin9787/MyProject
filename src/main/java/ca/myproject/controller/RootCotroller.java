package ca.myproject.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import ca.myproject.dao.ProductDao;
import ca.myproject.model.Product;

@Controller
public class RootCotroller {

	@Autowired
	private ProductDao productDao;

	private Path path;

	@RequestMapping("/")
	public String home() {

		return "home";
	}

	@RequestMapping("/productlist")
	public String getProductList(Model model) {
		List<Product> products = productDao.listAllProduct();
		model.addAttribute("products", products);
		return "productList";

	}

	@RequestMapping("/productlist/details/{productId}")
	public String getProductDetail(@PathVariable String productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}

	@RequestMapping("/admin")
	public String adminPage() {

		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productDao.listAllProduct();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductStatus("New");
		product.setProductStatus("active");
		product.setProductDescription("New product");
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProdcutPost(@ModelAttribute("product") Product product, HttpServletRequest request) {

		productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		String root = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(root + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".jpg");

		if (productImage != null && !productImage.isEmpty())

		{
			try {
				File test =new File(path.toString());
				productImage.transferTo(test);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(" File failed to upload", e);
			}

		}

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId, Model model) {
		productDao.deleteProduct(productId);
		return "redirect:/admin/productInventory";
	}
}

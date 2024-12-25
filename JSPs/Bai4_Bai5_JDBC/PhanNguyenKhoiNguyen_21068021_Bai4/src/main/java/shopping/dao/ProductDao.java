package shopping.dao;

import java.util.List;

import shopping.entities.Product;

public interface ProductDao {
	public List<Product> findAll();
	public Product getProductByID(int id);
	public void addProduct(Product p);
}

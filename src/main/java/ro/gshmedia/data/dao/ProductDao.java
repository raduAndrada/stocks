package ro.gshmedia.data.dao;

import ro.gshmedia.data.model.Product;

public interface ProductDao {

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public Product getProduct(int id);


}

package com.pbang.service;

import com.pbang.model.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(Integer id);
    String deleteProduct(Integer id);
    Product editProduct(Product product, Integer id);
}
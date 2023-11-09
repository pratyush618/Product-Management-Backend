package com.pbang.serviceImpl;

import com.pbang.model.Product;
import com.pbang.repository.ProductRepository;
import com.pbang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product product = productRepo.findById(id).orElse(null);
        if (product != null) {
            productRepo.delete(product);
            return "Product Deleted Successfully";
        } else {
            return "Product Not Found";
        }
    }

    @Override
    public Product editProduct(Product product, Integer id) {
        Product oldProduct = productRepo.findById(id).orElse(null);
        assert oldProduct != null;
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStatus(product.getStatus());

        return productRepo.save(oldProduct);
    }

}

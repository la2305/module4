package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

//    @Override
//    public Product selectById(int id) {
//        return productRepository.selectById(id);
//    }
//
//    @Override
//    public void editProduct(int id, Product product) {
//        productRepository.editProduct(id,product);
//    }
//
//    @Override
//    public void deleteProduct(int id) {
//        productRepository.deleteProduct(id);
//    }
//
//    @Override
//    public List<Product> search(String name) {
//        return productRepository.search(name);
//    }

}

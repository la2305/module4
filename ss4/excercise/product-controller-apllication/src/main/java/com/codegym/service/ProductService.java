package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private static IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public Product selectById(int id) {
        return productRepository.selectById(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        productRepository.editProduct(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

}

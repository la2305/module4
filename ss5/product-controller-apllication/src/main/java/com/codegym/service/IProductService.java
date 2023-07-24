package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct(Product product);
    Product selectById(int id);
    void editProduct(int id,Product product);
    void deleteProduct(int id);
    List<Product> search(String name);
}

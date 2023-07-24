package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product",Product.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product selectById(int id) {
        Product product =entityManager.find(Product.class,id);
        return product;
    }
    @Transactional
    @Override
    public void editProduct(int id, Product product) {
        Product product1 = selectById(id);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setProducer(product.getProducer());
        entityManager.merge(product1);
    }
    @Transactional
    @Override
    public void deleteProduct(int id) {
        Product product = selectById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("from Product",Product.class);
        List<Product> productList1 = query.getResultList();
        for (int i = 0; i < productList1.size(); i++) {
            if (productList1.get(i).getName().contains(name)){
                productList.add(productList1.get(i));
            }
        }
        return productList;
    }
}

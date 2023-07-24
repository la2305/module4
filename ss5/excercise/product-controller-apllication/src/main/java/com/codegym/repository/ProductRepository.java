package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ",Product.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

//    @Override
//    public Product selectById(int id) {
////        return mapProduct.get(id);
//    }

//    @Override
//    public void editProduct(int id, Product product) {
//        mapProduct.put(id,product);
//    }
//
//    @Override
//    public void deleteProduct(int id) {
//        mapProduct.remove(id);
//    }
//
//    @Override
//    public List<Product> search(String name) {
//        List<Product> productList = new ArrayList<>();
//        for (Product product: mapProduct.values()) {
//            if (product.getName().equals(name)){
//                productList.add(product);
//            }
//        }
//        return productList;
//    }


}

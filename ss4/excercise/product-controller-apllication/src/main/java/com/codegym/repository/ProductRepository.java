package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
    private static final Map<Integer,Product> listProduct = new HashMap<>();
    static {
        listProduct.put(1,new Product(1,"Bánh",5000,"Bánh chocopie","Hoàng hà"));
        listProduct.put(2,new Product(2,"Kẹo",1000,"Kẹo bạc hà","Coconut"));
        listProduct.put(3,new Product(3,"Mứt",2000,"Mứt dừa","La"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void addProduct(Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public Product selectById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        listProduct.put(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        listProduct.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        for (Product product:listProduct) {

        }
    }


}

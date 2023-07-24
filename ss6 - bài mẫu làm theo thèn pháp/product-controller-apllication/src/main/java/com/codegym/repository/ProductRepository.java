package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository{
    private static final Map<Integer,Product> mapProduct = new HashMap<>();
    static {
        mapProduct.put(1,new Product(1,"Bánh",5000,"Bánh chocopie","Hoàng hà"));
        mapProduct.put(2,new Product(2,"Kẹo",1000,"Kẹo bạc hà","Coconut"));
        mapProduct.put(3,new Product(3,"Mứt",2000,"Mứt dừa","La"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(mapProduct.values());
    }

    @Override
    public void addProduct(Product product) {
        mapProduct.put(product.getId(), product);
    }

    @Override
    public Product selectById(int id) {
        return mapProduct.get(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        mapProduct.put(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        mapProduct.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product: mapProduct.values()) {
            if (product.getName().equals(name)){
                productList.add(product);
            }
        }
        return productList;
    }


}

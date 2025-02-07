package com.example.productsdemo.service;

import com.example.productsdemo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Bé Na","dài 2m","3000"));
        products.add(new Product(2,"Rồng","dài 12m","48000"));
        products.add(new Product(3,"Trâu ","dài 8m","12000"));
        products.add(new Product(4,"Muỗi","dài 2m","5000"));
    }
    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteProductById(int id) {
        products.removeIf(product -> product.getId() == id);

    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void savaProduct(Product product) {
        products.add(product);
    }
}

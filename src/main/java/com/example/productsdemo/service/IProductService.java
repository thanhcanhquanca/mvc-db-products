package com.example.productsdemo.service;

import com.example.productsdemo.model.Product;

import java.util.List;

public interface IProductService{
    List<Product> getAllProducts();
    Product getProductById(int id);
    void deleteProductById(int id);
    void updateProduct(int id,Product product);
    void savaProduct(Product product);
}

package com.example.productsdemo.service;

import com.example.productsdemo.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceDB implements IProductService {

    private Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/productsdb";
            String user = "root";
            String password = "@Chuanhquan1211z";
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("chay thanh cong database");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return connection;
    }
    @Override
    public List<Product> getAllProducts() {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ProductTb");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(String.valueOf(resultSet.getInt("price")));
                products.add(product);
            }
            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void deleteProductById(int id) {

    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void savaProduct(Product product) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ProductTb (name, description, price) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ProductTb (name, description, price) VALUES (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

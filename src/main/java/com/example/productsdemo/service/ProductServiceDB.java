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
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select * from ProductTb where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(String.valueOf(resultSet.getInt("price")));
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public void deleteProductById(int id) {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from ProductTb where id = ?");
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("san pham duoc xoa thanh cong");
            }else {
                System.out.println("khong tim thay san pham");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(int id, Product product) {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update ProductTb set nam = ? description = ? price = ? where id = ? ");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, Integer.parseInt(product.getPrice()));
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("san pham duoc cap nhap lai thanh cong");
            }else {
                System.out.println("khong tim thay san pham");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void savaProduct(Product product) {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ProductTb (name, description, price) VALUES (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.executeUpdate();

//            CallableStatement callableStatement = null;
//            callableStatement = connection.prepareCall("{ CALL SaveProducts(?, ?, ?) }");
//            callableStatement.setString(1, product.getName());
//            callableStatement.setString(2, product.getDescription());
//            callableStatement.setString(3, product.getPrice());
//            callableStatement.executeUpdate();


            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

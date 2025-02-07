package com.example.productsdemo.controller;

import com.example.productsdemo.model.Product;
import com.example.productsdemo.service.IProductService;
import com.example.productsdemo.service.ProductService;
import com.example.productsdemo.service.ProductServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/products")
public class ProductController extends HttpServlet {
    private final IProductService productService = new ProductServiceDB();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                CreateProduct(req,resp);
                break;
            case "delete":
                DeleteProduct(req,resp);
                break;
            default:
                resp.sendRedirect("/products");
        }
    }

    private void DeleteProduct(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void CreateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        int idInt = Integer.parseInt(id);

        Product product = new Product(idInt,name,description,price);
        productService.savaProduct(product);
        resp.sendRedirect("/products");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                showCreateProduct(req,resp);
                break;
            case "list":
                showProducts(req,resp);
                break;
            case "delete":
                showDeleteProduct(req,resp);
                break;
                default:
                showProducts(req,resp);
        }




    }

    private void showDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/delete.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/products.jsp");
    List<Product> products = productService.getAllProducts();
    req.setAttribute("products", products);
    requestDispatcher.forward(req,resp);
    }

    private void showCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(req,resp);
    }
}

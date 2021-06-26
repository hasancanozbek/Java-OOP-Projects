package com.hasancanozbek.Northwind.Api.controllers;

import com.hasancanozbek.Northwind.Business.abstracts.ProductService;
import com.hasancanozbek.Northwind.Entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.gelAll();
    }
}

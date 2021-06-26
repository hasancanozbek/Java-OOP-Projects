package com.hasancanozbek.Northwind.Business.concretes;

import com.hasancanozbek.Northwind.Business.abstracts.ProductService;
import com.hasancanozbek.Northwind.DataAccess.abstracts.ProductDao;
import com.hasancanozbek.Northwind.Entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public List<Product> gelAll() {
        return this.productDao.findAll();
    }
}

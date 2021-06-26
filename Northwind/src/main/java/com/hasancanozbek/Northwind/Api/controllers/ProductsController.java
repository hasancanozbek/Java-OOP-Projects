package com.hasancanozbek.Northwind.Api.controllers;

import com.hasancanozbek.Northwind.Business.abstracts.ProductService;
import com.hasancanozbek.Northwind.Entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Controllers, projelerimizde Api dediğimiz katmanı oluşturur. Burada yazdığımız kodlar ile kullanıcıların hangi istekte
bulunduğunu ve bu isteğe cevap olarak ne yapılacağını belirtiriz. Bir e-ticaret sitemiz olduğunu varsayalım.
Domain Adı : hasancanozbek.com olsun. hasancanozbek.com/api/products adresine gidildiğinde aslında bu class'a gidiliyor.
Burada /getall adresi database'den çektiğimiz ürünleri gösteriyor. Başka adresler de aynı şekilde belirtilebiliyor.
Bu yapı aynı zamanda bir kere yazılıp ister mobil ister masaüstü ister web üzerinden kullanılabiliyor.
Back-end'i bir kere yazıyoruz ve her platformda kullanabiliyoruz(React, Angular, Swing, Android Uygulama Geliştirme platformları).
Özetle API yapısı back end ile front end arasındaki iletişimi sağlıyor, java ile diğer diller arasında tercümanlık
yapıyor diyebiliriz.
 */

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

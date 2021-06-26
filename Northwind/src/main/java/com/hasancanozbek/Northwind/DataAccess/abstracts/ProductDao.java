package com.hasancanozbek.Northwind.DataAccess.abstracts;

import com.hasancanozbek.Northwind.Entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
    /*
    Entities katmanında @Entity anotasyonu ile belirttiğimiz class'ı buraya ekliyoruz. Bu sayede Spring, Jpa'yı kullanarak
    bizim için CRUD operasyonlarını yazmış oluyor. Bu yapıyı kullanmasaydık BankApp projesinde yaptığımız gibi tek tek elle
    insert, update ve delete operasyonlarını sql kullnarak eklememiz gerekecekti. Integer olarak belirttiğimiz kısım ise
    Entity objemizin primary key'inin hangi tür olduğu. (Birden çok özellik tutucu class olabilirdi, Spring'e hangi nesneyi
    database'e ekleyeceğini belirtmemiz gerekiyor.
     */

}

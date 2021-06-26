package com.hasancanozbek.Northwind.Entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //Getter-Setter, toString, equalsAndHashCode yapılarını sizin yerinize kurar.
@NoArgsConstructor // Parametresiz constructor oluşturur.
@AllArgsConstructor // Classta final olmayan tüm fieldların parametrede bulunduğu bir constructor kurar.

@Entity // Bu classın Entity katmanına ait bir nesne(veritabanında tabloya karşılık geldiğini) olduğunu Spring'e Jpa vasıtasıyla belirtiyoruz.
@Table(name = "products") // Veritabanında hangi tabloya karşılık geldiğini belirttik.
public class Product {

    @Id // Bu annotation ile tablomuzda bulunan primary key'e sahip kolonumuzu belirttik.
    @GeneratedValue // Primary key'in otomatik olarak arttığını java tarafında id arttırma işlemi yapılamamsını söyledik.
    @Column(name = "product_id") // @Column anotasyonları ile ilgili field'ın veritabanında hangi sütuna karşılık gedliğini belirttik.
    private int id;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;


}

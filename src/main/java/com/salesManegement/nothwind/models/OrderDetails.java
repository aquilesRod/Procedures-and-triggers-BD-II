package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Order Details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id")
    private int Id;

    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "ProductID")
    private int ProductID;

    @Column(name = "UnitPrice")
    private double UnitPrice;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Discount")
    private double Discount;
    
}

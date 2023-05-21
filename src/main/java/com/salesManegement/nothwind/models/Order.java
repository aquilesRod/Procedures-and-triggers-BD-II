package com.salesManegement.nothwind.models;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Orders")
public class Order {

    // OrderID" "int" IDENTITY (1, 1) NOT NULL ,
	// "CustomerID" nchar (5) NULL ,
	// "EmployeeID" "int" NULL ,
	// "OrderDate" "datetime" NULL ,
	// "RequiredDate" "datetime" NULL ,
	// "ShippedDate" "datetime" NULL ,
	// "ShipVia" "int" NULL ,
	// "Freight" "money" NULL CONSTRAINT "DF_Orders_Freight" DEFAULT (0),
	// "ShipName" nvarchar (40) NULL ,
	// "ShipAddress" nvarchar (60) NULL ,
	// "ShipCity" nvarchar (15) NULL ,
	// "ShipRegion" nvarchar (15) NULL ,
	// "ShipPostalCode" nvarchar (10) NULL ,
	// "ShipCountry" nvarchar (15) NULL 

    @Id
    @Column(name = "OrderID")
    private int OrderID;

	// @ManyToOne
	@Column(name = "CustomerID")
    private String CustomerID;

	// @ManyToOne
	@Column(name = "EmployeeID")
    private int EmployeeID;

    @Column(name = "OrderDate")
    private Date OrderDate;

    @Column(name = "RequiredDate")
    private Date RequiredDate;

    @Column(name = "ShippedDate")
    private Date ShippedDate;

	@Column(name = "ShipVia")
    private int ShipVia;

    @Column(name = "Freight")
    private double Freight;

	@Column(name = "ShipName")
    private String ShipName;

	@Column(name = "ShipAddress")
    private String ShipAddress;

	@Column(name = "ShipCity")
    private String ShipCity;

	@Column(name = "ShipRegion")
    private String ShipRegion;

	@Column(name = "ShipPostalCode")
    private String ShipPostalCode;

	@Column(name = "ShipCountry")
    private String ShipCountry;
    
}


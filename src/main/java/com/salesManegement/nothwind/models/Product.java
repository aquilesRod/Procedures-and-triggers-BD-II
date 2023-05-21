
package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Products")
public class Product {

    // "ProductID" "int" IDENTITY (1, 1) NOT NULL ,
	// "ProductName" nvarchar (40) NOT NULL ,
	// "SupplierID" "int" NULL ,
	// "CategoryID" "int" NULL ,
	// "QuantityPerUnit" nvarchar (20) NULL ,
	// "UnitPrice" "money" NULL CONSTRAINT "DF_Products_UnitPrice" DEFAULT (0),
	// "UnitsInStock" "smallint" NULL CONSTRAINT "DF_Products_UnitsInStock" DEFAULT (0),
	// "UnitsOnOrder" "smallint" NULL CONSTRAINT "DF_Products_UnitsOnOrder" DEFAULT (0),
	// "ReorderLevel" "smallint" NULL CONSTRAINT "DF_Products_ReorderLevel" DEFAULT (0),
	// "Discontinued" "bit" NOT NULL CONSTRAINT "DF_Products_Discontinued" DEFAULT (0),

    @Id
    @Column(name = "ProductID")
    private int ProductID;

    @Column(name = "ProductName")
    private String ProductName;

    // @ManyToOne
    @Column(name = "SupplierID")
    private int SupplierID;

    // @ManyToOne
    @Column(name = "CategoryID")
    private int CategoryID;

    @Column(name = "QuantityPerUnit")
    private String QuantityPerUnit;

    @Column(name = "UnitPrice")
    private double UnitPrice;

    @Column(name = "UnitsInStock")
    private int UnitsInStock;

    @Column(name = "UnitsOnOrder")
    private int UnitsOnOrder;

    @Column(name = "ReorderLevel")
    private int ReorderLevel;

    @Column(name = "Discontinued")
    private Boolean Discontinued;
    
}


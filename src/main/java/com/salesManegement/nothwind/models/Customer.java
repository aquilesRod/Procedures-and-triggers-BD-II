package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Customers")
public class Customer {
    
    // "CustomerID" nchar (5) NOT NULL ,
	// "CompanyName" nvarchar (40) NOT NULL ,
	// "ContactName" nvarchar (30) NULL ,
	// "ContactTitle" nvarchar (30) NULL ,
	// "Address" nvarchar (60) NULL ,
	// "City" nvarchar (15) NULL ,
	// "Region" nvarchar (15) NULL ,
	// "PostalCode" nvarchar (10) NULL ,        
	// "Country" nvarchar (15) NULL ,
	// "Phone" nvarchar (24) NULL ,
	// "Fax" nvarchar (24) NULL ,

    @Id
    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "CompanyName")
    private String CompanyName;

    @Column(name = "ContactName")
    private String ContactName;

    @Column(name = "ContactTitle")
    private String ContactTitle;

    @Column(name = "Address")
    private String Address;

    @Column(name = "City")
    private String City;

    @Column(name = "Region")
    private String Region;

    @Column(name = "PostalCode")
    private String PostalCode;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "Fax")
    private String Fax;

    @Override
    public String toString() {
        return "Customers [CustomerID=" + CustomerID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName
                + ", ContactTitle=" + ContactTitle + ", Address=" + Address + ", City=" + City + ", Region=" + Region
                + ", PostalCode=" + PostalCode + ", Country=" + Country + ", Phone=" + Phone + ", Fax=" + Fax + "]";
    }

}

package com.salesManegement.nothwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesManegement.nothwind.models.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {
    
}

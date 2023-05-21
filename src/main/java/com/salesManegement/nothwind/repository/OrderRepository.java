package com.salesManegement.nothwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesManegement.nothwind.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,String>{
    
}

package com.salesManegement.nothwind.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salesManegement.nothwind.models.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> ObterProdutosMaisCaros(){
        return productRepository.ObterProdutosMaisCaros();
    }

}

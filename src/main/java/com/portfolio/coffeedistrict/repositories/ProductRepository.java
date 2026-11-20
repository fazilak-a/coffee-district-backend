package com.portfolio.coffeedistrict.repositories;

import com.portfolio.coffeedistrict.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>  {

}

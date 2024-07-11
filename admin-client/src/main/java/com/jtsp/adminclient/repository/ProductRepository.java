package com.jtsp.adminclient.repository;

import com.jtsp.adminclient.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

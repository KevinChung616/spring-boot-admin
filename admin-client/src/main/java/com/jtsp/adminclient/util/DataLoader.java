package com.jtsp.adminclient.util;

import com.jtsp.adminclient.model.entity.Product;
import com.jtsp.adminclient.repository.ProductRepository;
import com.jtsp.adminclient.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("loading initial data batch");
        productRepository.saveAll(Arrays.asList(
                Product.builder()
                        .name("Apple iPhone 13")
                        .category("Electronics")
                        .amount(100L)
                        .build(),
                Product.builder()
                        .name("Samsung Galaxy S21")
                        .category("Electronics")
                        .amount(200L)
                        .build(),
                Product.builder()
                        .name("Sony WH-1000XM4")
                        .category("Electronics")
                        .amount(300L)
                        .build(),
                Product.builder()
                        .name("Nike Air Max 270")
                        .category("Footwear")
                        .amount(400L)
                        .build(),
                Product.builder()
                        .name("Adidas Ultraboost")
                        .category("Footwear")
                        .amount(500L)
                        .build(),
                Product.builder()
                        .name("Levi's 501 Original")
                        .category("Clothing")
                        .amount(600L)
                        .build(),
                Product.builder()
                        .name("Ralph Lauren Polo Shirt")
                        .category("Clothing")
                        .amount(700L)
                        .build(),
                Product.builder()
                        .name("The Catcher in the Rye")
                        .category("Books")
                        .amount(800L)
                        .build(),
                Product.builder()
                        .name("To Kill a Mockingbird")
                        .category("Books")
                        .amount(900L)
                        .build(),
                Product.builder()
                        .name("Omega Seamaster")
                        .category("Watches")
                        .amount(1000L)
                        .build()
        ));
    }
}

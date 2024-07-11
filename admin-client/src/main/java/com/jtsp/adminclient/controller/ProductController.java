package com.jtsp.adminclient.controller;

import com.jtsp.adminclient.mapper.ProductMapper;
import com.jtsp.adminclient.model.dto.ProductDTO;
import com.jtsp.adminclient.model.entity.Product;
import com.jtsp.adminclient.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService service;

    private final ProductMapper mapper;

    @Autowired
    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        String traceId = Thread.currentThread().getName();
        String timestamp = Instant.now().toString();
        log.info("Request received: traceId={}, timestamp={}, method=createProduct, endpoint=/products, HTTP Method=POST", traceId, timestamp);
        log.debug("accept request to create product: {}", productDTO.toString());
        if (productDTO.getCategory().equals("Error")) {
            throw new RuntimeException("error exception");
        }
        return ResponseEntity.ok(service.createProduct(mapper.toProduct(productDTO)));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @RequestParam(defaultValue = "name") String sortBy) {
        return ResponseEntity.ok(service.getProducts(page, size, sortBy));
    }
}

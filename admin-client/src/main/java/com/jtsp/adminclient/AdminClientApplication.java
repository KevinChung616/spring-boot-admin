package com.jtsp.adminclient;

import com.jtsp.adminclient.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class AdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.trace("this is trace level hellooooo.");
        log.debug("this is debug level hellooo.");
        log.info("this is info level helloo.");
        log.warn("this is warn level hello.");
        log.error("this is error level hi.");
        return ResponseEntity.ok("check the log.");
    }
}

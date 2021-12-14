package com.sinan.productapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sinan.productapi.models.Product;
import com.sinan.productapi.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private transient ProductRepository repository;

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return repository.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeProductById(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
}

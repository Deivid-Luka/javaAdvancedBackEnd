package com.example.demo.controller;

import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class Controller {
    @Autowired
    ProductService productService;

    @GetMapping()
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody String searchCriteria) {
        try{
            return ResponseEntity.ok(productService.search(searchCriteria));
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody ProductDto productDto, @PathVariable Long id) {
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("deleted");
    }
}

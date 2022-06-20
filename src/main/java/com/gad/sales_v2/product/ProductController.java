package com.gad.sales_v2.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("products")
@Transactional(readOnly = true)
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/active")
    public List<Product> getAllActive(){
        return productService.getAllByActiveTrue();
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id") Long id) throws IOException {
        return productService.getById(id);
    }

    @GetMapping("names/{search}")
    public List<String> getNames(@PathVariable("search") String search){
        return productService.getNames(search);
    }

    @GetMapping("names/{search}/category/{category}")
    public List<String> getNamesByCategory(@PathVariable("search") String search, @PathVariable("category") String category){
        return productService.getNamesByCategory(search, category);
    }

    @GetMapping("name/{name}/category/{category}")
    public Long getIdByNameAndCategory(@PathVariable("name") String name, @PathVariable("category") String category){
        return productService.getNameByCategory(name, category);
    }

    @PostMapping
    @Transactional
    public Product save(@RequestBody ProductDTO productDTO) throws IOException {
        return productService.saveOrUpdate(productDTO);
    }

    @GetMapping("name/{productName}")
    @Transactional
    public ProductDTO getProductIdAndCategoryNameByProductName(@PathVariable("productName") String productName){
        return productService.getProductIdAndCategoryNameByProductName(productName);
    }

    @PatchMapping("update/{id}/{stock}")
    @Transactional
    public Boolean update(@PathVariable("id") Long id, @PathVariable("stock") Integer stock){
        return productService.update(id, stock);
    }
}


package com.gad.sales_v2.category;

import com.gad.sales_v2.product.Product;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("active")
    public List<Category> getAllByActiveTrue(){
        return categoryService.getAllByActiveTrue();
    }

    @GetMapping("/without")
    public List<Category> getWithoutProducts(){

        return categoryService.getWithoutProducts();
    }

    @GetMapping("/names")
    public List<String> getNames(){
        return categoryService.getNames();
    }

    @GetMapping("name/product/{id}")
    public String getNameByProductId(@PathVariable("id") Long id){
        return new Gson().toJson(categoryService.getNameByProductId(id));
    }

    @GetMapping("{name}")
    public List<Product> getProducts(@PathVariable("name") String name){
        return categoryService.getProducts(name);
    }

    @GetMapping("names/{searchValue}")
    public List<String> getCategoriesByName(@PathVariable("searchValue") String value){
        return categoryService.getCategoriesByName(value);
    }

    @PutMapping
    public Category update(@RequestBody Category category){
        return categoryService.saveOrUpdate(category);
    }

    @DeleteMapping
    public Category delete(@RequestBody Category category){
        return categoryService.delete(category);
    }
}

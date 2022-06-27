package com.gad.sales_v2.category;

import com.gad.sales_v2.product.Product;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveOrUpdate(Category category){
        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category delete(Category category){
        category.setActive(false);
        return categoryRepository.save(category);
    }

    public Iterable<Category> saveOrUpdateAll(List<Category> categories){
        return categoryRepository.saveAll(categories);
    }

    public List<Category> getAllByActiveTrue(){
        return categoryRepository.getAllByActiveTrue();
    }

    public Category getByName(String name){
        return categoryRepository.getByName(name);
    }

    public List<Category> getWithoutProducts(){
        List<String> names = categoryRepository.getNames();
        List<Category> categories = new ArrayList<>();
        names.forEach(name -> {
            try {
                categories.add(new Category(name, getImgBase64(getImagePath(name))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return categories;
    }

    public List<String> getNames(){
        return categoryRepository.getNames();
    }

    public String getNameByProductId(Long id) {
        return categoryRepository.getNameByProductId(id);
    }

    public List<Product> getProducts(String name){
        List<Product> products = categoryRepository.getProducts(name);
        products.forEach(product -> {
            try {
                product.setProductImage(getImgBase64(product.getProductImage()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    private static String getImagePath(String agentPhoto){
        return String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\category-photos\\%s.png",
                agentPhoto);
    }

    private String getImgBase64(String imagePath) throws IOException {
        String imgBase64= "data:image/png;base64,";
        File image = new File(imagePath);
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return imgBase64.concat(Base64.encodeBase64String(fileContent));
    }

    public List<String> getCategoriesByName(String value) {
        return categoryRepository.getCategoriesByName(value);
    }
}


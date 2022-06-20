package com.gad.sales_v2.product;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveOrUpdate(ProductDTO productDTO) throws IOException {
        String imgBase64 = productDTO.getProductImage();
        String[] tokens = imgBase64.split(",");
        String img = tokens[1];
        BufferedImage bufferedImage;
        byte[] imageByte = Base64.decodeBase64(img);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageByte);
        bufferedImage = ImageIO.read(byteArrayInputStream);
        byteArrayInputStream.close();
        File outputFile = new File(String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\product-images\\%s.png",
                productDTO.getName()));
        ImageIO.write(bufferedImage, "png", outputFile);
        productDTO.setProductImage(outputFile.getPath());
        Product product = new Product(
                productDTO.getProductImage(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getStock(),
                productDTO.getDescription(),
                true,
                productRepository.getCategoryByName(productDTO.getCategoryName())
        );
        return productRepository.save(product);
    }

    public List< Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getAllByActiveTrue(){
        return productRepository.getAllByActiveTrue();
    }

    public Product getById(Long id) throws IOException {
        Product product = productRepository.getById(id);
        product.setProductImage(getProductImageBase64(product.getProductImage()));
        return product;
    }

    public List<String> getNames(String name){
        return productRepository.getNames(name);
    }

    private String getProductImageBase64(String imagePath) throws IOException {
        String imgBase64 = "data:image/png;base64,";
        File image = new File(imagePath);
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return imgBase64.concat(Base64.encodeBase64String(fileContent));
    }

    public List<String> getNamesByCategory(String search, String category) {
        return productRepository.getNamesByCategory(search, category);
    }

    public Long getNameByCategory(String name, String category) {
        return productRepository.getIdByNameAndCategory(name, category);
    }

    public ProductDTO getProductIdAndCategoryNameByProductName(String productName){
        String[] strings = productRepository.getProductIdAndCategoryNameByProductName(productName);
        if(strings.length > 0) {
            String[] token = strings[0].split(",");
            return new ProductDTO(
                    Long.parseLong(token[0]),
                    token[1]
            );
        }
        return null;
    }

    public Boolean update(Long id, Integer stock) {
        Product product = productRepository.getById(id);
        product.setStock(stock);
        productRepository.updateStock(product.getId(), stock);
        return productRepository.getById(id).getStock() == stock;
    }
}


package com.gad.sales_v2.product_quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQuantityService {
    private final ProductQuantityRepository productQuantityRepository;

    @Autowired
    public ProductQuantityService(ProductQuantityRepository productQuantityRepository) {
        this.productQuantityRepository = productQuantityRepository;
    }

    public ProductQuantity saveOrUpdate(ProductQuantity productQuantity){
        return productQuantityRepository.save(productQuantity);
    }
}

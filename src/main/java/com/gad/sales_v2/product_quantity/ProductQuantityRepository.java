package com.gad.sales_v2.product_quantity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQuantityRepository extends CrudRepository<ProductQuantity, Long> {
}

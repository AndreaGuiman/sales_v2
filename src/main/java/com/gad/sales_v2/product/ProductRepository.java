package com.gad.sales_v2.product;

import com.gad.sales_v2.category.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product getById(Long id);

    List<Product> getAllByActiveTrue();

    @Query("select p.name from product p where p.name like concat('%', ?1, '%') ")
    List<String> getNames(String name);

    @Query("select p.name from product p " +
            "inner join category c on c.id = p.category.id and c.name = ?2 " +
            "where p.name like concat('%', ?1, '%') ")
    List<String> getNamesByCategory(String search, String category);

    @Query("select p.id from product p " +
            "inner join category c on c.id = p.category.id and c.name = ?2 " +
            "where p.name = ?1")
    Long getIdByNameAndCategory(String name, String category);

    @Query("select c from category c where c.name = ?1")
    Category getCategoryByName(String categoryName);

    @Procedure
    String[] getProductIdAndCategoryNameByProductName(String productName);

    @Query("update product p set p.stock = ?2 where p.id = ?1")
    @Modifying
    void updateStock(Long id, Integer stock);
}

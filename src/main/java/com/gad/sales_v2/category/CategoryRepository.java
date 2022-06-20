package com.gad.sales_v2.category;

import com.gad.sales_v2.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> getAllByActiveTrue();

    Category getByName(String name);

    @Query("select c.name from category c where c.active = true")
    List<String> getNames();

    @Query("select c.name from category c inner join product p on p.category.id = c.id and p.id = ?1")
    String getNameByProductId(Long id);

    @Query("select c.products from category c where c.name = ?1")
    List<Product> getProducts(String name);

    @Query("select c.name from category c where c.name like concat('%', ?1, '%') ")
    List<String> getCategoriesByName(String value);
}

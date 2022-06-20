package com.gad.sales_v2.client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client getById(Long id);

    @Query("select c.name from client c where c.name like concat('%', ?1, '%') ")
    List<String> getByNameSearchValue(String searchValue);

    @Query("select c.id from client c where c.name = ?1")
    Long getIdByName(String name);

    @Query("select case when count(c.id) > 0 then true else false" +
            " end from client c where c.vatOrIdNumber = ?1")
    Boolean existsClientByVatOrIdNumber(String vatOrIdNumber);

    @Query("select c from client c where c.vatOrIdNumber = ?1")
    Client foundByVat(String vatOrIdNumber);
}

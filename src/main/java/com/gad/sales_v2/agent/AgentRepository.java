package com.gad.sales_v2.agent;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
    List<Agent> getAllByActiveTrue();

    Agent getById(Long id);

    @Query("select a.id, concat(a.firstName, ' ', a.lastName) from agent a where a.user.id = ?1")
    String getByUserId(Long id);

    @Query("select concat(a.firstName, ' ', a.lastName) from agent a")
    List<String> getNames();

    @Query("select a.id from agent a where concat(a.firstName, ' ', a.lastName) = ?1")
    Long getByName(String name);

    @Query("select a from agent a where a.id = ?1")
    Agent getPhoto(Long id);
}

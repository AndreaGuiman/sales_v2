package com.gad.sales_v2.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u.id, u.userRole from user u where u.username = ?1 and u.password = ?2")
    String getByUsernameAndPassword(String username, String password);

    User getById(Long id);
}

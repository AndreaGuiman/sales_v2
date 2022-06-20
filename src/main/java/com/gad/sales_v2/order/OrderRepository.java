package com.gad.sales_v2.order;

import com.gad.sales_v2.agent.Agent;
import com.gad.sales_v2.client.Client;
import com.gad.sales_v2.product.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Procedure
    String[] getTopNProductsSoldByAgent(Long idAgent, Date beginDate, Date endDate);

    @Procedure
    String[] getProductSoldByAgent(Long idAgent, String productName, Date beginDate, Date endDate);

    @Procedure
    String[] getTopNCategoriesSoldByAgent(Long id, Date beginDate, Date endDate);

    @Procedure
    String[] getCategorySoldByAgent(Long id, String categoryName, Date beginDate, Date endDate);

    @Procedure
    String[] getGraphAgents(Date beginDate, Date endDate);

    @Procedure
    String[] getGraphAgent(Integer selectedAgentId, Date beginDate, Date endDate);

    List<Order> getByStatusAndAgentId(String status, Long id);

    Order getById(Long id);

    List<Order> getByClientId(Long id);

    @Query("select p from product p where p.name = ?1")
    Product getProductByName(String productName);

    @Query("select count(a.id) from agent a")
    Integer getNumberOfAgents();

    @Query("select concat(a.firstName, ' ', a.lastName) from agent a where a.id = ?1")
    String getAgentById(Long id);

    @Query("select c from client c where c.id = ?1")
    Client getClientByClientId(Long idClient);

    @Query("select a from agent a where a.id = ?1")
    Agent getAgentByAgentId(Long idAgent);

    @Query("select p from product p where p.id = ?1")
    Product getProductByProductId(Long aLong);

    List<Order> getByStatus(String status);

    @Modifying
    @Query("update order_table ot set ot.status = 'CANCELED' where ot.id = ?1")
    void cancelOrder(Long id);

    @Modifying
    @Query("update product p set p = ?1 where p.id = ?2")
    void updateProduct(Product product, Long id);
}

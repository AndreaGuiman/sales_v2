package com.gad.sales_v2.order;

import com.gad.sales_v2.agent.AgentService;
import com.gad.sales_v2.client.ClientService;
import com.gad.sales_v2.product.ProductService;
import com.gad.sales_v2.util.entity.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@Transactional(readOnly = true)
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final ProductService productService;
    private final AgentService agentService;

    @Autowired
    public OrderController(OrderService orderService, ClientService clientService, ProductService productService,
                           AgentService agentService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.productService = productService;
        this.agentService = agentService;
    }

    @Transactional
    @GetMapping("top-products-by-agent/{idAgent}/{numberOfProducts}/{month}")
    public List<Graph> getTopNProductsSoldByLoggedAgent(@PathVariable("idAgent") Long idAgent, @PathVariable("numberOfProducts") Integer numberOfProducts,
                                                        @PathVariable("month") String month){
        return orderService.getTopNProductsSoldByLoggedAgent(idAgent, numberOfProducts, month);
    }

    @Transactional
    @GetMapping("top-products-by-agent/period/{idAgent}/{numberOfProducts}/{monthPeriodStart}/{monthPeriodEnd}")
    public List<Graph> getTopNProductsSoldByLoggedAgentPeriod(@PathVariable("idAgent") Long idAgent, @PathVariable("numberOfProducts") Integer numberOfProducts,
                                                              @PathVariable("monthPeriodStart") String monthPeriodStart,
                                                              @PathVariable("monthPeriodEnd") String monthPeriodEnd){
        return orderService.getTopNProductsSoldByLoggedAgent(idAgent, numberOfProducts, monthPeriodStart, monthPeriodEnd);
    }

    @Transactional
    @GetMapping("product-by-agent/{idAgent}/{productName}/{month}")
    public Graph getProductSoldByAgent(@PathVariable("idAgent") Long idAgent, @PathVariable("productName") String productName,
                                       @PathVariable("month") String month){
        return orderService.getProductSoldByAgent(idAgent, productName, month);
    }

    @Transactional
    @GetMapping("product-by-agent/period/{idAgent}/{productName}/{monthPeriodStart}/{monthPeriodEnd}")
    public List<Graph> getProductSoldByAgentPeriod(@PathVariable("idAgent") Long idAgent, @PathVariable("productName") String productName,
                                             @PathVariable("monthPeriodStart") String monthPeriodStart,
                                             @PathVariable("monthPeriodEnd") String monthPeriodEnd){
        return orderService.getProductSoldByAgent(idAgent, productName, monthPeriodStart, monthPeriodEnd);
    }

    @Transactional
    @GetMapping("categories-by-agent/{idAgent}/{numberOfCategories}/{month}")
    public List<Graph> getCategoriesSoldByAgent(@PathVariable("idAgent") Long idAgent, @PathVariable("month") String month,
                                                @PathVariable("numberOfCategories") Integer numberOfCategories){
        return orderService.getCategoriesSoldByAgent(idAgent, numberOfCategories, month);
    }

    @Transactional
    @GetMapping("category-by-agent/{idAgent}/{categoryName}/{month}")
    public Graph getCategoryForAgent(@PathVariable("idAgent") Long idAgent, @PathVariable("month") String month,
                                     @PathVariable("categoryName") String categoryName){
        return orderService.getCategorySoldByAgent(idAgent, month, categoryName);
    }

    @Transactional
    @GetMapping("agents/{numberOfAgents}/{month}")
    public List<Graph> getGraphAgents(@PathVariable("numberOfAgents") Integer numberOfAgents, @PathVariable("month") String month){
        return orderService.getGraphAgents(numberOfAgents, month);
    }

    @Transactional
    @GetMapping("agent/{selectedAgentId}/{month}")
    public Graph getGraphAgent(@PathVariable("selectedAgentId") Integer selectedAgentId, @PathVariable("month") String month){
        return orderService.getGraphAgent(selectedAgentId, month);
    }

    @GetMapping("show/{status}/{id}")
    public List<OrderDTO> getAllByStatus(@PathVariable("status") String status, @PathVariable("id") Long id){
        return orderService.getByStatusAndAgentId(status, id);
    }

    @GetMapping("id/{id}")
    public OrderDTO getById(@PathVariable("id") Long id){
        return orderService.getById(id);
    }

    @GetMapping(value = "pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getPDF(@PathVariable("id") Long id){
        return orderService.getPDF(id);
    }

    @GetMapping("client/history/{id}")
    public List<OrderDTO> getByClient(@PathVariable("id") Long id){
        return orderService.getByClient(id);
    }

    @Transactional
    @PostMapping
    public Long saveOrder(@RequestBody Cart cart) throws Exception {
        return orderService.saveOrUpdate(cart);
    }

    @Transactional
    @PatchMapping("cancel/{id}")
    public Order cancelOrder(@PathVariable("id") Long id) throws InterruptedException {
        return orderService.cancelOrder(id);
    }

    @PostMapping("email/{id}")
    public void sendEmail(@PathVariable("id") Long id) throws Exception {
        orderService.sendEmail(id);
    }
}


package com.gad.sales_v2.util.config;

import com.gad.sales_v2.agent.AgentConfig;
import com.gad.sales_v2.agent.AgentRepository;
import com.gad.sales_v2.category.CategoryConfig;
import com.gad.sales_v2.category.CategoryRepository;
import com.gad.sales_v2.client.ClientConfig;
import com.gad.sales_v2.client.ClientRepository;
import com.gad.sales_v2.order.Order;
import com.gad.sales_v2.order.OrderConfig;
import com.gad.sales_v2.order.OrderRepository;
import com.gad.sales_v2.product.ProductConfig;
import com.gad.sales_v2.product.ProductRepository;
import com.gad.sales_v2.product_quantity.ProductQuantity;
import com.gad.sales_v2.util.entity.Liamed;
import com.gad.sales_v2.util.pdf.PDFService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(AgentRepository agentRepository, CategoryRepository categoryRepository, ProductRepository productRepository,
                                        OrderRepository orderRepository, ClientRepository clientRepository){
        return args -> {
            AgentConfig.createAndSaveAgents(agentRepository);
            CategoryConfig.createAndSaveCategories(categoryRepository);
            ProductConfig.createAndSaveProductsWithCategory(productRepository, categoryRepository);
            ClientConfig.createAndSaveClients(clientRepository);
            OrderConfig.createAndSaveOrders(orderRepository, agentRepository, clientRepository, productRepository);

            Order order = new Order(
                    orderRepository.getAgentByAgentId(1L),
                    orderRepository.getClientByClientId(1L),
                    "OPEN",
                    orderRepository.getProductByProductId(1L).getPrice(),
                    LocalDateTime.now(),
                    LocalDateTime.now().plusDays(2L),
                    List.of(
                            new ProductQuantity(
                                    orderRepository.getProductByProductId(1L), 1, orderRepository.getProductByProductId(1L).getPrice())
                    )
            );
            orderRepository.save(order);
            PDFService.createAndSave(order);
        };
    }
}

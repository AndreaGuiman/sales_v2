package com.gad.sales_v2.order;

import com.gad.sales_v2.agent.Agent;
import com.gad.sales_v2.agent.AgentRepository;
import com.gad.sales_v2.client.Client;
import com.gad.sales_v2.client.ClientRepository;
import com.gad.sales_v2.product.Product;
import com.gad.sales_v2.product.ProductRepository;
import com.gad.sales_v2.product_quantity.ProductQuantity;
import com.gad.sales_v2.util.pdf.PDFService;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class OrderConfig {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void createAndSaveOrders(OrderRepository orderRepository, AgentRepository agentRepository, ClientRepository clientRepository,
                                           ProductRepository productRepository) {
        createOrdersForAllAgents(orderRepository, agentRepository, clientRepository, productRepository);
    }

    private static void createOrdersForAllAgents(OrderRepository orderRepository, AgentRepository agentRepository, ClientRepository clientRepository,
                                                 ProductRepository productRepository) {
        createOrdersForAgent1(orderRepository, agentRepository, clientRepository, productRepository);
        createOrdersForAgent2(orderRepository, agentRepository, clientRepository, productRepository);
        createOrdersForAgent3(orderRepository, agentRepository, clientRepository, productRepository);
        createOrdersForAgent4(orderRepository, agentRepository, clientRepository, productRepository);
    }

    private static void createOrdersForAgent1(OrderRepository orderRepository, AgentRepository agentRepository, ClientRepository clientRepository,
                                              ProductRepository productRepository) {
        Agent agent = getAgent(agentRepository, 1L);
        List<Order> orders = List.of(
                getOrder(
                        agent,
                        clientRepository,
                        10L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                20,
                                9,
                                46
                        ),
                        16L, 11L, 14L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                27,
                                14,
                                53
                        ),
                        7L, 4L, 2L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                28,
                                14,
                                53
                        ),
                        4L, 1L, 8L, 10L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                5,
                                13,
                                53
                        ),
                        3L, 2L, 5L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                10,
                                14,
                                53
                        ),
                        1L, 3L, 5L, 12L, 5L, 7L, 2L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        10L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                25,
                                14,
                                53
                        ),
                        1L, 13L, 12L, 10L, 3L, 2L, 3L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                29,
                                16,
                                53
                        ),
                        1L, 16L, 4L, 13L, 1L, 5L, 6L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                4,
                                11,
                                23
                        ),
                        10L, 12L, 1L, 15L, 1L, 5L, 6L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                7,
                                14,
                                27
                        ),
                        14L, 11L, 12L, 13L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        5L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                9,
                                16,
                                3
                        ),
                        3L, 15L, 14L, 13L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                11,
                                14,
                                53
                        ),
                        1L, 3L, 4L, 5L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                14,
                                9,
                                46
                        ),
                        2L, 12L, 3L, 4L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                18,
                                14,
                                53
                        ),
                        5L, 16L, 11L, 15L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                20,
                                14,
                                53
                        ),
                        5L, 1L, 7L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                21,
                                13,
                                53
                        ),
                        7L, 9L, 6L, 8L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        1L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                26,
                                14,
                                53
                        ),
                        5L, 8L, 11L, 16L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        9L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                29,
                                14,
                                53
                        ),
                        1L, 3L, 6L
                )
        );
        saveOrderAndCreatePDF(orderRepository, orders);
    }

    private static void createOrdersForAgent2(OrderRepository orderRepository, AgentRepository agentService, ClientRepository clientRepository,
                                              ProductRepository productRepository){
        Agent agent = getAgent(agentService, 2L);
        List<Order> orders = List.of(
                getOrder(
                        agent,
                        clientRepository,
                        3L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                6,
                                14,
                                53
                        ),
                        10L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        1L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                12,
                                16,
                                53
                        ),
                        3L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                15,
                                11,
                                23
                        ),
                        2L, 1L, 6L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                16,
                                14,
                                27
                        ),
                        2L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                6,
                                14,
                                53
                        ),
                        9L, 3L, 5L, 2L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                8,
                                13,
                                53
                        ),
                        13L, 12L, 15L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                11,
                                14,
                                53
                        ),
                        14L, 5L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        9L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                25,
                                14,
                                53
                        ),
                        14L, 5L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        1L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                22,
                                14,
                                53
                        ),
                        3L, 16L, 8L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                7,
                                11,
                                23
                        ),
                        16L, 8L, 2L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                12,
                                14,
                                53
                        ),
                        1L, 3L, 5L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        9L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                20,
                                14,
                                53
                        ),
                        13L, 12L, 10L, 11L, 8L, 9L, 10L, 7L, 1L, 2L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                30,
                                16,
                                53
                        ),
                        1L, 16L, 14L, 13L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                4,
                                11,
                                23
                        ),
                        10L, 7L, 1L, 15L, 1L, 5L, 6L, 7L, 1L, 2L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                7,
                                14,
                                27
                        ),
                        4L, 11L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        5L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                9,
                                16,
                                3
                        ),
                        3L, 16L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                11,
                                14,
                                53
                        ),
                        1L, 3L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        5L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                14,
                                9,
                                46
                        ),
                        2L, 12L, 3L, 14L, 1L, 3L, 5L, 7L
                )
        );
        saveOrderAndCreatePDF(orderRepository, orders);
    }

    private static void createOrdersForAgent3(OrderRepository orderRepository, AgentRepository agentRepository, ClientRepository clientRepository,
                                              ProductRepository productRepository){
        Agent agent = getAgent(agentRepository, 3L);
        List<Order> orders = List.of(
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                6,
                                14,
                                53
                        ),
                        12L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                12,
                                16,
                                53
                        ),
                        3L, 4L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                15,
                                11,
                                23
                        ),
                        2L, 1L, 6L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                16,
                                14,
                                27
                        ),
                        2L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                25,
                                14,
                                53
                        ),
                        1L, 3L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        1L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                22,
                                14,
                                53
                        ),
                        13L, 7L, 8L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                7,
                                11,
                                23
                        ),
                        7L, 8L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                12,
                                14,
                                53
                        ),
                        1L, 3L, 5L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        5L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                9,
                                16,
                                3
                        ),
                        10L, 16L, 1L, 4L, 6L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                11,
                                14,
                                53
                        ),
                        1L, 3L, 9L, 10L, 11L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                14,
                                9,
                                46
                        ),
                        2L, 12L, 13L, 4L, 1L, 3L, 5L, 7L
                )
        );
        saveOrderAndCreatePDF(orderRepository, orders);
    }

    private static void createOrdersForAgent4(OrderRepository orderRepository, AgentRepository agentRepository, ClientRepository clientRepository,
                                              ProductRepository productRepository){
        Agent agent = getAgent(agentRepository, 4L);
        List<Order> orders = List.of(
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                6,
                                14,
                                53
                        ),
                        12L, 12L, 3L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                12,
                                16,
                                53
                        ),
                        3L, 4L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        2L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                15,
                                11,
                                23
                        ),
                        2L, 1L, 6L, 7L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                1,
                                16,
                                14,
                                27
                        ),
                        2L, 1L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                25,
                                14,
                                53
                        ),
                        1L, 3L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        1L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                2,
                                22,
                                14,
                                53
                        ),
                        13L, 7L, 8L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        6L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                3,
                                7,
                                11,
                                23
                        ),
                        7L, 8L, 9L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        4L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                4,
                                12,
                                14,
                                53
                        ),
                        1L, 3L, 5L, 12L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        5L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                9,
                                16,
                                3
                        ),
                        10L, 16L, 1L, 4L, 6L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        8L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                11,
                                14,
                                53
                        ),
                        1L, 3L, 9L, 10L, 11L
                ),
                getOrder(
                        agent,
                        clientRepository,
                        7L,
                        productRepository,
                        LocalDateTime.of(
                                2022,
                                5,
                                14,
                                9,
                                46
                        ),
                        2L, 12L, 13L, 4L, 1L, 3L, 5L, 7L
                )
        );
        saveOrderAndCreatePDF(orderRepository, orders);
    }

    private static void saveOrderAndCreatePDF(OrderRepository orderRepository, List<Order> orders) {
        orders.forEach(order -> {
            Order tempOrder = orderRepository.save(new Order(
                    order.getId(),
                    order.getAgent(),
                    order.getClient(),
                    order.getStatus(),
                    order.getPrice(),
                    order.getDateOfOrder(),
                    order.getDateOfSending(),
                    order.getProductQuantities()
            ));
            try {
                createPDF(tempOrder);
            } catch (MalformedURLException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Agent getAgent(AgentRepository agentRepository, Long id){
        return agentRepository.getById(id);
    }

    private static Order getOrder(Agent agent, ClientRepository clientRepository, Long idClient, ProductRepository productRepository,
                                  LocalDateTime dateOfOrder, Long... ids){
        OrderStatus orderStatus = OrderStatus.SENT;
        int random = new Random().nextInt(4);
        boolean ok = false;
        while(!ok) {
            if (random > 1) {
                if(random == 2)
                    orderStatus = OrderStatus.CANCELED;
                ok = true;
            }
            else{
                random = new Random().nextInt(4);
            }
        }

        List<Product> products = getProducts(productRepository, ids);
        AtomicInteger quantity = new AtomicInteger();
        AtomicBoolean okRandom = new AtomicBoolean(false);
        Random randomQuantity = new Random();
        List<ProductQuantity> productQuantities = new ArrayList<>();
        products.forEach(product -> {
            quantity.set(randomQuantity.nextInt(10));
            while (!okRandom.get()){
                if(quantity.get() > 0){
                    okRandom.set(true);
                }
                else {
                    quantity.set(randomQuantity.nextInt(product.getStock()));
                }
            }
            okRandom.set(false);
            productQuantities.add(new ProductQuantity(product, quantity.get(), getProductPrice(product, quantity.get())));
        });
        return new Order(
                agent,
                getClient(clientRepository, idClient),
                orderStatus.name(),
                getPrice2(productQuantities),
                dateOfOrder,
                getDateOfSending(dateOfOrder),
                productQuantities
        );
    }

    private static double getPrice2(List<ProductQuantity> products){
        AtomicReference<Double> price = new AtomicReference<>((double) 0);
        products.forEach(product -> price.updateAndGet(v -> v + product.getPrice()));
        return Double.parseDouble(decimalFormat.format(price.get()));
    }

    private static double getProductPrice(Product product, int quantity){
        return Double.parseDouble(decimalFormat.format(product.getPrice() * quantity));
    }

    private static Client getClient(ClientRepository clientRepository, Long id){
        return clientRepository.getById(id);
    }

    private static List<Product> getProducts(ProductRepository productRepository, Long... ids){
        List<Product> products = new ArrayList<>();
        Arrays.stream(ids).forEach(id -> products.add(productRepository.getById(id)));
        return products;
    }

    private static LocalDateTime getDateOfSending(LocalDateTime localDateTime){
        return LocalDateTime.of(
                localDateTime.toLocalDate().plusDays(1),
                LocalTime.of(8, 0)
        );
    }

    private static void createPDF(Order order) throws MalformedURLException, FileNotFoundException {
        PDFService.createAndSave(order);
    }
}


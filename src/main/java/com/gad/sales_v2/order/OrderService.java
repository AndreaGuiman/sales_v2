package com.gad.sales_v2.order;

import com.gad.sales_v2.agent.Agent;
import com.gad.sales_v2.client.Client;
import com.gad.sales_v2.product.Product;
import com.gad.sales_v2.product_quantity.ProductQuantity;
import com.gad.sales_v2.util.entity.Graph;
import com.gad.sales_v2.util.mail.Credentials;
import com.gad.sales_v2.util.mail.MailService;
import com.gad.sales_v2.util.pdf.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long saveOrUpdate(Cart cart) throws Exception {
        Client client = orderRepository.getClientByClientId(cart.getIdClient());
        Agent agent = orderRepository.getAgentByAgentId(cart.getIdAgent());
        List<ProductQuantity> productQuantities = new ArrayList<>();
        List<Long> ids = cart.getProductIds();
        List<Integer> quantities = cart.getQuantities();
        int size = cart.getProductIds().size();
        Product product;
        int quantity;
        for(int i = 0; i < size; i++){
            product = orderRepository.getProductByProductId(ids.get(i));
            quantity = quantities.get(i);
            product.setStock(product.getStock() - quantity);
            orderRepository.updateProduct(product, product.getId());
            productQuantities.add(new ProductQuantity(product, quantity, product.getPrice() * quantity));
        }
        LocalDateTime dateOfSending = getDateOfSending(cart.getDateOfOrder());
        Order order = new Order(agent, client, cart.getStatus(), getPrice(productQuantities),
                cart.getDateOfOrder(), dateOfSending, productQuantities
        );
        order = orderRepository.save(order);
        try {
            createPDF(order);
            return order.getId();
        }catch (Exception e){
            return -1L;
        }
    }

    public List<Graph> getTopNProductsSoldByLoggedAgent(Long idAgent, Integer numberOfProducts, String month){
        Date beginDate = getBeginDate(month);
        Date endDate = getEndDate(month);
        return getGraphsFromProducts(orderRepository.getTopNProductsSoldByAgent(idAgent, beginDate, endDate), numberOfProducts);
    }

    public List<Graph> getTopNProductsSoldByLoggedAgent(Long idAgent, Integer numberOfProducts, String monthPeriodStart, String monthPeriodEnd){
        Date beginDate = getBeginDate(monthPeriodStart);
        Date endDate = getEndDate(monthPeriodEnd);
        return getGraphsFromProducts(orderRepository.getTopNProductsSoldByAgent(idAgent, beginDate, endDate), numberOfProducts);
    }

    public Graph getProductSoldByAgent(Long idAgent, String productName, String month){
        Date beginDate = getBeginDate(month);
        Date endDate = getEndDate(month);
        List<Graph> graphs = getGraphsFromProducts(orderRepository.getProductSoldByAgent(idAgent, productName, beginDate, endDate), 1);
        if(graphs.size() > 0){
            return graphs.get(0);
        }
        return new Graph();
    }

    public List<Graph> getProductSoldByAgent(Long idAgent, String productName, String monthPeriodStart, String monthPeriodEnd){
        Date beginDate = getBeginDate(monthPeriodStart);
        Date endDate = getEndDate(monthPeriodEnd);
        Date tempBeginDate, tempEndDate;
        int numberOfMonths = endDate.toLocalDate().getMonthValue() - beginDate.toLocalDate().getMonthValue();
        tempBeginDate = beginDate;
        List<Graph> graphs = new ArrayList<>();
        List<Graph> temp;
        for(int i = 0; i <= numberOfMonths; i++){
            tempEndDate = Date.valueOf(tempBeginDate.toLocalDate().plusMonths(1L));
            temp = getGraphsFromProducts(orderRepository.getProductSoldByAgent(idAgent, productName, tempBeginDate, tempEndDate),
                    1);
            if(temp.size() > 0) {
                for (Graph graph : temp) {
                    Graph monthGraph = new Graph();
                    monthGraph.setProductOrCategoryName(tempBeginDate.toLocalDate().getMonth().toString());
                    monthGraph.setPriceOfSoldProducts(graph.getPriceOfSoldProducts());
                    graphs.add(monthGraph);
                }
            }
            else{
                graphs.add(new Graph(tempBeginDate.toLocalDate().getMonth().toString(), 0, 0.0));
            }
            tempBeginDate = tempEndDate;
        }
        return graphs;
    }

    public Graph getCategorySoldByAgent(Long idAgent, String month, String categoryName){
        Date beginDate = getBeginDate(month);
        Date endDate = getEndDate(month);
        return getGraphsFromProducts(orderRepository.getCategorySoldByAgent(idAgent, categoryName, beginDate, endDate), 1).get(0);
    }

    public List<Graph> getGraphAgents(Integer numberOfAgents, String month) {
        Date beginDate = getBeginDate(month);
        Date endDate = getEndDate(month);
        List<Graph> graphs = new ArrayList<>();
        AtomicReference<Double> price = new AtomicReference<>((double) 0);
        List<Graph> tempGraph = new ArrayList<>();
        int totalNumberOfAgents = orderRepository.getNumberOfAgents();
        for(int i = 0; i < totalNumberOfAgents; i++){
            tempGraph = getGraphsFromProducts(orderRepository.getTopNProductsSoldByAgent((long) (i + 1), beginDate, endDate), numberOfAgents);
            tempGraph.forEach(temp -> {
                price.updateAndGet(v -> v + temp.getPriceOfSoldProducts());
            });
            Graph agentGraph = new Graph();
            agentGraph.setProductOrCategoryName(orderRepository.getAgentById((long) (i + 1)));
            agentGraph.setPriceOfSoldProducts(price.get());
            graphs.add(agentGraph);
        }
        graphs.sort(Comparator.comparing(Graph::getPriceOfSoldProducts).reversed());
        return graphs;
    }

    public Graph getGraphAgent(Integer selectedAgentId, String month) {
        Date beginDate = getBeginDate(month);
        Date endDate = getEndDate(month);
        return getGraphsFromProducts(orderRepository.getGraphAgent(selectedAgentId, beginDate, endDate), 1).get(0);
    }


    public OrderDTO getById(Long id) {
        return getOrderDTOs(List.of(orderRepository.getById(id))).get(0);
    }

    public List<OrderDTO> getByStatusAndAgentId(String status, Long id){
        return getOrderDTOs(orderRepository.getByStatusAndAgentId(status, id));
    }

    public List<Order> getByStatus(String status){
        return orderRepository.getByStatus(status);
    }

    public byte[] getPDF(Long id){
        try{
            String pdfName = String.format("C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\invoices\\%s.pdf", id);
            FileInputStream fileInputStream = new FileInputStream(pdfName);
            byte[] targetArray = new byte[fileInputStream.available()];
            fileInputStream.read(targetArray);
            return targetArray;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderDTO> getByClient(Long id) {
        return getOrderDTOs(orderRepository.getByClientId(id));
    }

    private List<OrderDTO> getOrderDTOs(List<Order> orders){

        List<OrderDTO> orderDTOs = new ArrayList<>();
        AtomicReference<List<ProductQuantity>> productQuantities = new AtomicReference<>(null);
        orders.forEach(order -> {
            productQuantities.set(order.getProductQuantities());
            orderDTOs.add(new OrderDTO(
                    order.getId(),
                    order.getAgent(),
                    order.getClient(),
                    getProducts(productQuantities.get()),
                    getQuantities(productQuantities.get()),
                    order.getStatus(),
                    getPrice(productQuantities.get()),
                    order.getDateOfOrder(),
                    order.getDateOfSending()
            ));
        });
        return orderDTOs;
    }

    private List<Product> getProducts(List<ProductQuantity> productQuantities){
        List<Product> products = new ArrayList<>();
        productQuantities.forEach(productQuantity -> {
            products.add(new Product(productQuantity.getProduct()));
        });
        return products;
    }

    private List<Integer> getQuantities(List<ProductQuantity> productQuantities){
        List<Integer> quantities = new ArrayList<>();
        productQuantities.forEach(productQuantity -> {
            quantities.add(productQuantity.getQuantity());
        });
        return quantities;
    }

    private double getPrice(List<ProductQuantity> productQuantities){
        AtomicReference<Double> price = new AtomicReference<>((double) 0);
        productQuantities.forEach(productQuantity ->
                price.updateAndGet(v -> v + productQuantity.getProduct().getPrice() * productQuantity.getQuantity()));
        return price.get();
    }

    private List<Graph> getGraphsFromProducts(String[] strings, Integer numberOfElementsForGraph) {
        List<Graph> graphs = new ArrayList<>();
        AtomicReference<String> productName = new AtomicReference<>();
        AtomicReference<Integer> quantity = new AtomicReference<>();
        AtomicReference<AtomicReferenceArray<String>> tokens = new AtomicReference<>(null);
        Arrays.stream(strings).forEach(s -> {
            tokens.set(new AtomicReferenceArray<>(s.split(",")));
            productName.set(tokens.get().get(0));
            quantity.set(Integer.parseInt(tokens.get().get(1)));
            graphs.add(new Graph(productName.get(), quantity.get(), getPriceForGraph(productName.get(), quantity.get())));
        });
        graphs.sort(Comparator.comparing(Graph::getPriceOfSoldProducts).reversed());
        if(graphs.size() <= numberOfElementsForGraph){
            return graphs;
        }
        return graphs.subList(0, numberOfElementsForGraph);
    }

    private double getPriceForGraph(String productName, Integer quantity){
        Product product = orderRepository.getProductByName(productName);
        return Double.parseDouble(decimalFormat.format(product.getPrice() * quantity));
    }

    private LocalDateTime getDateOfSending(LocalDateTime localDateTime){
        return LocalDateTime.of(
                localDateTime.toLocalDate().plusDays(1),
                LocalTime.of(17, 0)
        );
    }
    
    private Date getBeginDate(String month){
        switch (month){
            case "Ianuarie":
                return Date.valueOf(LocalDate.of(2022, 1, 1));
            case "Februarie":
                return Date.valueOf(LocalDate.of(2022, 2, 1));
            case "Martie":
                return Date.valueOf(LocalDate.of(2022, 3, 1));
            case "Aprilie":
                return Date.valueOf(LocalDate.of(2022, 4, 1));
            case "Mai":
                return Date.valueOf(LocalDate.of(2022, 5, 1));
            case "Iunie":
                return Date.valueOf(LocalDate.of(2022, 6, 1));
            case "Iulie":
                return Date.valueOf(LocalDate.of(2022, 7, 1));
            case "August":
                return Date.valueOf(LocalDate.of(2022, 8, 1));
            case "Septembrie":
                return Date.valueOf(LocalDate.of(2022, 9, 1));
            case "Octombrie":
                return Date.valueOf(LocalDate.of(2022, 10, 1));
            case "Noiembrie":
                return Date.valueOf(LocalDate.of(2022, 11, 1));
            case "Decembrie":
                return Date.valueOf(LocalDate.of(2022, 12, 1));
            default:
                return Date.valueOf(LocalDate.now());
        }
    }

    private Date getEndDate(String month){
        switch (month){
            case "Ianuarie":
                return Date.valueOf(LocalDate.of(2022, 1, 31));
            case "Februarie":
                return Date.valueOf(LocalDate.of(2022, 2, 28));
            case "Martie":
                return Date.valueOf(LocalDate.of(2022, 3, 31));
            case "Aprilie":
                return Date.valueOf(LocalDate.of(2022, 4, 30));
            case "Mai":
                return Date.valueOf(LocalDate.of(2022, 5, 31));
            case "Iunie":
                return Date.valueOf(LocalDate.of(2022, 6, 30));
            case "Iulie":
                return Date.valueOf(LocalDate.of(2022, 7, 31));
            case "August":
                return Date.valueOf(LocalDate.of(2022, 8, 31));
            case "Septembrie":
                return Date.valueOf(LocalDate.of(2022, 9, 30));
            case "Octombrie":
                return Date.valueOf(LocalDate.of(2022, 10, 31));
            case "Noiembrie":
                return Date.valueOf(LocalDate.of(2022, 11, 30));
            case "Decembrie":
                return Date.valueOf(LocalDate.of(2022, 12, 31));
            default:
                return Date.valueOf(LocalDate.now());
        }
    }

    public void sendEmail(Long id) throws Exception {

        Credentials credentials = new Credentials(
                "andreea_andree6@yahoo.com",
                "unqvllyqdthzknhb",
                "andreea_andree6@yahoo.com"
        );
        MailService.sendMailWithPDF(credentials, orderRepository.getById(id));
    }

    private void createPDF(Order order) throws MalformedURLException, FileNotFoundException {
        PDFService.createAndSave(order);
    }

    public Order cancelOrder(Long id) {
        Order order = orderRepository.getById(id);
        order.setStatus("CANCELED");
        order = orderRepository.save(order);
        order = orderRepository.getById(id);
        return order;
    }

    public Order update(Order order){
        return orderRepository.save(order);
    }
}

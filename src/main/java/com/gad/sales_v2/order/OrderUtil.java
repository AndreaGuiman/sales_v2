package com.gad.sales_v2.order;

import com.gad.sales_v2.util.mail.Credentials;
import com.gad.sales_v2.util.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderUtil {
    private final OrderService orderService;

    @Autowired
    public OrderUtil(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "0 0 17 * * MON-FRI")
    public void synchronizeOrders() throws Exception {
        List<Order> orders = orderService.getByStatus("OPEN");
        LocalDate localDate = LocalDate.now();
        List<Order> processedOrders = new ArrayList<>();
        orders.forEach(order -> {
            if(localDate.minusDays(1L).compareTo(order.getDateOfOrder().toLocalDate()) > 0){
                processedOrders.add(order);
                order.setStatus(OrderStatus.SENT.name());
                orderService.update(order);
            }
        });

        Credentials credentials = new Credentials(
                "andreea_andree6@yahoo.com",
                "unqvllyqdthzknhb",
                "andreea_andree6@yahoo.com"
        );
        MailService.sendSyncMail(credentials, processedOrders);
    }
}

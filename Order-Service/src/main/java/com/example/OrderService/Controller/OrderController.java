package com.example.OrderService.Controller;

import com.example.OrderService.Exception.NoOrderPresentException;
import com.example.OrderService.Exception.ResourceNotFoundException;
import com.example.OrderService.Service.OrderService;
import com.example.OrderService.Service.SequenceGeneratorService;
import com.example.OrderService.entity.CouponAndDeals;
import com.example.OrderService.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    RestTemplate restTemplate;

    Order order = new Order();

    CouponAndDeals couponAndDeals = new CouponAndDeals();
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() throws NoOrderPresentException {
        List<Order> list = orderService.getAllOrders();
        if (list.isEmpty()) {
            throw new NoOrderPresentException("There are no orders present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id) throws NoOrderPresentException {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            throw new NoOrderPresentException("No order found with id: " + id);
        }
        return ResponseEntity.ok(order.get());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) throws ResourceNotFoundException {

        String couponName = order.getCouponName();
        if(couponName == null){
            throw new ResourceNotFoundException("No Coupon Found with name "+couponName);
        }
        else {
            CouponAndDeals couponAndDeals1 = restTemplate.getForObject("http://Coupon-And-Deals/couponAndDeals/couponName/" +
                    couponName, CouponAndDeals.class);
            double cost = couponAndDeals1.getCouponPrice() * order.getQuantity();
            order.setCost(cost);
            order.setId(sequenceGeneratorService.getSequenceNumber(Order.SEQUENCE_NAME));
            String x = "Your order with order Id " + order.getId() + " with value " + cost + " is placed";
            Order savedOrder = orderService.saveOrder(order);
            return ResponseEntity.ok(x);
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable int id) throws NoOrderPresentException {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            throw new NoOrderPresentException("No " +
                    "order found with id: " + id);
        }
        orderService.deleteOrderById(id);
    }


}
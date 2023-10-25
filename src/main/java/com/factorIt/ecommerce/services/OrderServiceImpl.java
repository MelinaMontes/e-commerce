package com.factorIt.ecommerce.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;
import com.factorIt.ecommerce.entities.Order;
import com.factorIt.ecommerce.entities.OrderDetail;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.enums.Payment;
import com.factorIt.ecommerce.ordercoasts.OrderCoast;
import com.factorIt.ecommerce.ordercoasts.TotalCoast;
import com.factorIt.ecommerce.repositories.OrderDetailRepository;
import com.factorIt.ecommerce.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

  @Autowired
  CartService cartService;

  @Autowired 
  OrderRepository orderRepository;

  @Autowired
  OrderDetailRepository orderDetailRepository;

  @Override
  public void makeAnOrder(User user) {
    List<ItemsCartDTO> items = cartService.getItemsFromUser(user);

    int allItems = items.stream().mapToInt(ItemsCartDTO::getQuantity).sum();
    boolean VIP = checkIfVIP(user);
    //boolean special= cartService.isSpecial(user);

    TotalCoast orderCoast= OrderCoast.getAmountTotal(VIP, allItems, true);
    BigDecimal coast = orderCoast.calculateOrderCoast(items);
    boolean discountUsed=VIP;

    Order order = new Order();
    order.setCreatedDate(LocalDate.now());
    order.setUser(user);
    order.setTotalPrice(coast);
    order.setPayment(Payment.CREDITCARD);
    order.setVip(discountUsed);
    orderRepository.save(order);

    for(ItemsCartDTO itemsCartDTO: items){
      OrderDetail orderDetail= new OrderDetail();
      orderDetail.setQuantity(itemsCartDTO.getQuantity());
      orderDetail.setCreatedDate(LocalDate.now());
      orderDetail.setProduct(itemsCartDTO.getProduct());
      orderDetail.setUnitPrice(itemsCartDTO.getProduct().getUnitPrice());
      orderDetailRepository.save(orderDetail);

    }
    cartService.finishCarrt(user);



  }

  //func. ver si es vip
  private boolean checkIfVIP(User user) {
    //busco mes, fecha y año actual
    //inicio y fin del mes actual
    LocalDate today = LocalDate.now();
    YearMonth currentMonth = YearMonth.now();

    LocalDate start = currentMonth.atDay(1);
    LocalDate stop = start.plusMonths(1).minusDays(1);

    //buscamos las ordenes mensuales del user
    List<Order> orders = orderRepository.findByUserAndCreatedDateBetween(user, start, stop, Sort.by(Sort.Direction.ASC, "createdDate"));

    //vemos si tuvo descuentos
    if (orders.stream().anyMatch(Order:: isVip)) {
        return false;
    }

    //vemos cuanto gasto en el mes, si es +10000 es vip
    BigDecimal totalSpent = orders.stream()
            .map(Order::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    return totalSpent.compareTo(BigDecimal.valueOf(10000)) > 0;
}

@Override
public List<Order> getOrders(User user) {
    List<Order> orders = orderRepository.findAll();
    return orders;
}

  }



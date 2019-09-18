package com.pigeon.fly.controller;


import com.pigeon.fly.model.Address;
import com.pigeon.fly.model.Order;
import com.pigeon.fly.model.Pigeon;
import com.pigeon.fly.model.User;
import com.pigeon.fly.repository.AdressRepository;
import com.pigeon.fly.repository.OrderRepository;
import com.pigeon.fly.repository.PigeonRepository;
import com.pigeon.fly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static org.aspectj.runtime.internal.Conversions.intValue;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

  @Autowired
  AdressRepository adressRepository;

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  PigeonRepository pigeonRepository;

  @Autowired
  UserRepository userRepository;

  @PostMapping("/order")
  public RedirectView createPost(@RequestBody Map<String, Object> request) {

    int pigeonId = Integer.parseInt(request.get("pigeonName").toString());

    Address deliveryAddress = new Address(request.get("pickUpCountry").toString(), request.get("pickUpCity").toString(), request.get("pickUpAddress").toString());
    adressRepository.save(deliveryAddress);

    Address pickUpAddress = new Address(request.get("deliveryCountry").toString(), request.get("deliveryCity").toString(), request.get("deliveryAddress").toString());
    adressRepository.save(pickUpAddress);

    User user = new User(request.get("name").toString(), request.get("eMail").toString());
    userRepository.save(user);

    Order order = new Order(pickUpAddress.getId(), deliveryAddress.getId(), pigeonId, intValue(user.getId()));
    orderRepository.save(order);

    Pigeon pigeon = pigeonRepository.findAll().get(pigeonId);
    pigeon.setAvailable(false);
    pigeonRepository.save(pigeon);

    return new RedirectView("/");
  }
}

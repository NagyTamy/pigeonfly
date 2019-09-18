package com.pigeon.fly.controller;

import com.pigeon.fly.model.Pigeon;
import com.pigeon.fly.repository.PigeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PigeonController {
    @Autowired
    PigeonRepository pigeonRepository;

    @GetMapping("")
    public List<Pigeon> getAllPigeons(){
      return pigeonRepository.findAll();
    }
}

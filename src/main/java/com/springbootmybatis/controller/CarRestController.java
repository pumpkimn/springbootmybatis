package com.springbootmybatis.controller;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<?> getCars(){
        List<Car> cars = carService.list();
     return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}

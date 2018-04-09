package com.springbootmybatis.controller;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.domain.CustomType;
import com.springbootmybatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<?> getCars(){
        List<Car> cars = carService.list();
        if (cars.isEmpty()){
            return new ResponseEntity<>(new CustomType(400,"查询不到结果"), HttpStatus.OK);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/car/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@PathVariable("id")Integer id){
        Car car = carService.find(id);
        if (car == null ){
            return new ResponseEntity<>(new CustomType(400,id+"匹配不到结果"), HttpStatus.OK);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/addcars",method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car car){
        CustomType customType = new CustomType(400,"增加失败");
        int count = carService.add(car);
        if (count > 0){
            customType.setCode(200);
            customType.setMessage("增加成功");
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/modifycars",method = RequestMethod.POST)
    public ResponseEntity<?> modifyCar(@RequestBody Car car){
        CustomType customType = new CustomType(400,"修改失败");
        int count = carService.modify(car);
        if (count > 0){
            customType.setCode(200);
            customType.setMessage("修改成功");
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        int count = carService.remove(id);
        return new ResponseEntity<>(new CustomType(200,id+"删除成功"),HttpStatus.OK);
    }



}

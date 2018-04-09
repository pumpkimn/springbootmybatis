package com.springbootmybatis.service;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public List<Car> list(){
        return carMapper.find();
    }

    public Car find(Integer id){
        return carMapper.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int add(Car car){
        return carMapper.addCar(car);
    }

    public int modify(Car car){
        return carMapper.modifyCar(car);
    }

    public int remove(Integer id){
        return carMapper.removeCar(id);
    }
}

package com.springbootmybatis;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.mapper.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTest {
    @Autowired
    private CarMapper carMapper;

    @Test
    public void find() {
        for (Car car:carMapper.find()){
            System.out.println(car.getName());
        }
    }

    @Test
    public void findParam() {
        for (Car car:carMapper.findByParam("马",null)){
            System.out.println(car.getName());
        }
    }
}

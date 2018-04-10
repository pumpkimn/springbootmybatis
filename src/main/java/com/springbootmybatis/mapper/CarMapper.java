package com.springbootmybatis.mapper;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.domain.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 映射器接口
 */
public interface CarMapper {

    @Select("select id,name,price,create_date createDate from car where id=#{id}")
    Car findById(Integer id);

    @Select("select id,name,price,create_date createDate from car")
   /* @Results(
            @Result(property = "createDate", column = "create_date")
    )*/
    List<Car> find();

    @Update("update car set name=#{name},price=#{price},create_date=#{createDate} where id=#{id}")
    int modifyCar(Car car);

    @Insert("insert into car(name,price,create_date) values (#{name},#{price},#{createDate})")
    int addCar(Car car);

    @Delete("delete car where id=#{id}")
    int removeCar(Integer id);

    /* 条件查询 */
    List<Car> findByParam(@Param("name") String name,
                          @Param("price") Double price);
}

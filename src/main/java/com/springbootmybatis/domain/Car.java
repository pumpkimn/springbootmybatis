package com.springbootmybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car implements Serializable {
    // Java中的类名对应数据库中的表名
    // 类的属性对应表的字段
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Integer id;
    private String name;
    private Double price;

    private Date createDate;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                '}';
    }

}

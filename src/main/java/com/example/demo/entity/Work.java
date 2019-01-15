package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Work implements Serializable{
    private Integer id;
    private BigDecimal salary;
    private Integer deptId;
    private String name;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", salary=" + salary +
                ", deptId=" + deptId +
                ", name='" + name + '\'' +
                '}';
    }
}
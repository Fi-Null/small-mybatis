package com.small.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Department
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/15 23:45
 * @Version 1.0
 **/
public class Department implements Serializable {
    private int id;
    private String departmentName;
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
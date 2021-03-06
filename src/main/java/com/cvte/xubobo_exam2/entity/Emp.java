package com.cvte.xubobo_exam2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Emp {

    @Id
    @GeneratedValue
    private Integer empId;

    @Column(nullable = false)
    private String empName;


    private Integer deptId;

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}

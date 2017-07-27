package com.cvte.xubobo_exam2.controller;

import com.cvte.xubobo_exam2.entity.Dept;
import com.cvte.xubobo_exam2.repository.*;
import com.cvte.xubobo_exam2.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private DeptService deptService;

    //得到顶级部门（根部门）
    @GetMapping(value = "/deptRoot")
    public List<Dept> detpRoot(){
        return deptRepository.findByParentId(null);
    }

    //根据部门id查询所有的子部门
    @GetMapping(value = "/childDepts/{deptId}")
    public List<Dept> deptList(@PathVariable(value = "deptId") Integer deptId){
        if (deptId == 0) return  deptRepository.findByParentId(null);
        else return deptRepository.findByParentId(deptId);
    }


    //添加一个部门，参数：部门名称，父部门
    @PostMapping(value = "/dept")
    public Dept deptAdd(@RequestParam("deptName") String deptName,
                        @RequestParam("parentId") Integer parentId){
        Dept dept = new Dept();
        dept.setDeptName(deptName);
        dept.setParentId(parentId);

        return deptRepository.save(dept);
    }

    //更新部门信息（包括移动部门）
    @PutMapping(value = "dept/{deptId}")
    public Dept deptUpdate(@PathVariable("deptId") Integer deptId,
                           @RequestParam("deptName") String deptName,
                           @RequestParam("parentId") Integer parentId){
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        dept.setDeptName(deptName);
        dept.setParentId(parentId);

        return deptRepository.save(dept);
    }

    //输入部门id，删除其子部门和该部门
    @DeleteMapping(value = "depts/{deptId}")
    public void deptDeleteByDeptId(@PathVariable("deptId") Integer deptId){
        deptService.deleteByDeptId(deptId);
    }
}

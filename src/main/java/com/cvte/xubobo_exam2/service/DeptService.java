package com.cvte.xubobo_exam2.service;

import com.cvte.xubobo_exam2.repository.*;
import com.cvte.xubobo_exam2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Transactional
    public void deleteByDeptId(@PathVariable("deptId") Integer deptId){
        deptRepository.delete(deptRepository.findByParentId(deptId));
        deptRepository.delete(deptId);
    }


}

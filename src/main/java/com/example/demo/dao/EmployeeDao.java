package com.example.demo.dao;

import com.example.demo.po.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午7:34 2018/4/25
 */
public interface EmployeeDao extends JpaRepository<Employee,Long> {
}

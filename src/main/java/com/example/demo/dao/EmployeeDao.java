package com.example.demo.dao;

import com.example.demo.po.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午7:34 2018/4/25
 */
public interface EmployeeDao extends JpaRepository<Employee,Long> {

    @Query(value = "select e from Employee e where e.name=:name")
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "select e from Employee e where e.age=:age")
    List<Employee> findByAge(@Param("age") int age);

    @Query(value = "select e from Employee e where e.gender=:gender")
    List<Employee> findByGender(@Param("gender") int gender);
}

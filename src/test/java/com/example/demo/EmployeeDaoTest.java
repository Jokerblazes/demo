package com.example.demo;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.po.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午7:30 2018/4/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setGender(1);
        employee.setName("小明");
        Employee save1 = employeeDao.save(employee);
        assertEquals(save1,employee);
    }




}

package com.example.demo;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.po.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        employee.setGender("男");
        employee.setName("小明");
        Employee save = employeeDao.save(employee);
        compareEmployeesEqual(employee,save);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = createXIaoHong();
        Employee save = employeeDao.save(employee);
        compareEmployeesEqual(employee,save);
    }

    private Employee createXIaoHong() {
        Employee employee = new Employee();
        employee.setId((long)2);
        employee.setAge(19);
        employee.setGender("女");
        employee.setName("小红");
        return employee;
    }

    private void compareEmployeesEqual(Employee employee1,Employee employee2) {
        assertEquals(employee1.getId(),employee2.getId());
        assertEquals(employee1.getAge(),employee2.getAge());
        assertEquals(employee1.getGender(),employee2.getGender());
        assertEquals(employee1.getName(),employee2.getName());
    }

    @Test
    public void testDeleteEmployee() {
        employeeDao.deleteById((long)1);
        Employee employee = createXIaoHong();
        employeeDao.delete(employee);
    }

    @Test
    public void testGetAllEmployee() {
        //小明
        Employee employee1 = createXIaoMing();

        //小红
        Employee employee2 = createXIaoHong();
        List<Employee> all = employeeDao.findAll();
        assertTrue(all.size() >= 2);
        compareEmployeesEqual(all.get(0),employee1);
        compareEmployeesEqual(all.get(1),employee2);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeDao.findById((long) 1).get();
        //小明
        Employee employee1 = createXIaoMing();
        compareEmployeesEqual(employee1,employee);
    }

    private Employee createXIaoMing() {
        Employee employee1 = new Employee();
        employee1.setId((long)1);
        employee1.setAge(20);
        employee1.setGender("男");
        employee1.setName("小明");
        return employee1;
    }

    @Test
    public void testGetEmployeeByName() {
        List<Employee> employees = employeeDao.findByName("小明");
        assertTrue(employees.size() >= 1);

        //小明
        Employee employee1 = createXIaoMing();
        compareEmployeesEqual(employee1,employees.get(0));
    }

    @Test
    public void testGetEmployeeByAge() {
        List<Employee> employees = employeeDao.findByAge(20);
        assertTrue(employees.size() >= 1);

        //小明
        Employee employee1 = createXIaoMing();
        compareEmployeesEqual(employee1,employees.get(0));
    }

    @Test
    public void testGetEmployeeByGender() {
        List<Employee> employees = employeeDao.findByGender(1);
        assertTrue(employees.size() >= 1);

        //小明
        Employee employee1 = createXIaoMing();
        compareEmployeesEqual(employee1,employees.get(0));
    }
}

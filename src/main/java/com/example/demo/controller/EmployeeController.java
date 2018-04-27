package com.example.demo.controller;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午9:05 2018/4/25
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/employees")
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeDao.findById(id).get();
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeesByName(@RequestParam("name") String name) {
        return employeeDao.findByName(name);
    }

    @RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeesByAge(@PathVariable Integer age) {
        return employeeDao.findByAge(age);
    }

    @RequestMapping(value = "/gender", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees(@RequestParam("gender") String gender) {
        System.out.println(gender);
        return employeeDao.findByGender(gender);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteEmployee(@PathVariable Long id) {
        employeeDao.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "success";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "success";
    }

    @RequestMapping("/employeePage")
    public ModelAndView  getEmployeesPage() {
        return new ModelAndView("employee", "employees", employeeDao.findAll());
    }




}

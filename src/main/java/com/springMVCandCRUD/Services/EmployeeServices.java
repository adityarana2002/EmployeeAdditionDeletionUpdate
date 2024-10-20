package com.springMVCandCRUD.Services;

import com.springMVCandCRUD.Entity.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

package com.springMVCandCRUD.Repository;

import com.springMVCandCRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

    // add a method to sort by last name
}

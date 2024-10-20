package com.springMVCandCRUD.Services;

import com.springMVCandCRUD.Entity.Employee;
import com.springMVCandCRUD.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService implements  EmployeeServices {

//    @Autowired
    private EmpRepo empRepo;

    @Autowired
    public EmpService(EmpRepo theEmpRepo){
        empRepo= theEmpRepo;
    }

    @Override
    public  List<Employee> findAll(){
        return empRepo.findAll();
    }

    @Override
    public Employee findById(int theId){
        Optional<Employee>result = empRepo.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not fing Employee id = " +theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee
                         theEmployee){
        return empRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId){
        empRepo.deleteById(theId);
    }


}

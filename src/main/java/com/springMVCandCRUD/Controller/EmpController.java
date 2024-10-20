package com.springMVCandCRUD.Controller;

import com.springMVCandCRUD.Entity.Employee;
import com.springMVCandCRUD.Repository.EmpRepo;
import com.springMVCandCRUD.Services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmpController {

    private EmpService employeeService;

    @Autowired
    public EmpController(EmpService theEmpService){
        employeeService = theEmpService;
    }

    @GetMapping("/list")
    public String listEmployee(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";

    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

//        create mode attribute to bind form data
            Employee theEmployee = new Employee();
            theModel.addAttribute("employee",theEmployee);
            return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){

        Employee theEmployee = employeeService.findById(theId);

        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);

        return "redirect:/employees/list";

    }


}

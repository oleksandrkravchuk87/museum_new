package ok.controllers;

import ok.dto.EmployeeDTO;
import ok.entity.Employee;
import ok.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    public String allEmployees(Model model) {
        List<EmployeeDTO> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "views-employee-all";
    }
    @RequestMapping (value = "/employee/add", method = RequestMethod.GET)
    public String newEmployee (Model model){
        model.addAttribute("employee", new Employee());
        return "views-employee-add";
    }






    @RequestMapping (value = "/employee/new", method = RequestMethod.POST)
    public String createEmployee (@RequestParam("name")String name, @RequestParam("secondName")String secondName, @RequestParam("middleName")String middleName, @RequestParam("phone")String phone, @RequestParam("email")String email, @RequestParam("birthDate")String birthDate,  @RequestParam("position")String position, @RequestParam("image")MultipartFile multipartFile){
        employeeService.addOrEdit(name, secondName, middleName, phone, email, birthDate, position, multipartFile);
        return "redirect:/employee/all";
    }




    @RequestMapping (value = "/employee/page/{id}",method = RequestMethod.GET)
    public String employeePage (@PathVariable String id, Model model){
        Employee employee = employeeService.findOne(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "views-employee-page";







    }
    @RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.findOne(Integer.parseInt(id)));
        return "views-employee-edit";
    }

    @RequestMapping(value = "/employee/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id")int id,@RequestParam("name")String name, @RequestParam("secondName")String secondName, @RequestParam("middleName")String middleName, @RequestParam("phone")String phone, @RequestParam("email")String email, @RequestParam("birthDate")String birthDate,  @RequestParam("position")String position, @RequestParam("image")MultipartFile multipartFile) {
        employeeService.edit(id, name, secondName, middleName, phone, email, birthDate, position, multipartFile);
        return "redirect:/employee/all";
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        employeeService.delete(Integer.parseInt(id));
        return "redirect:/employee/all";
    }


}

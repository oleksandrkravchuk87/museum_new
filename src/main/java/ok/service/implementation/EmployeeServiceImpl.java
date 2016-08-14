package ok.service.implementation;

import ok.dto.EmployeeDTO;
import ok.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ok.repository.EmployeeRepo;
import ok.service.EmployeeService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public void addOrEdit(Employee employee) {employeeRepo.save(employee);
    }

    public void delete(int id) {
employeeRepo.delete(id);
    }

    public Employee findOne(int id) {
        return employeeRepo.findOne(id);
    }

    public void addOrEdit(String name, String secondName, String middleName, String phone, String email, String birthDate, String position, MultipartFile multipartFile) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSecondName(secondName);
        employee.setMiddleName(middleName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setBirthDate(birthDate);
        employee.setPosition(position);
        try {
            employee.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeRepo.save(employee);
    }
    public void edit(int id, String name, String secondName, String middleName, String phone, String email, String birthDate, String position, MultipartFile multipartFile) {
        Employee employee = employeeRepo.findOne(id);
        employee.setName(name);
        employee.setSecondName(secondName);
        employee.setMiddleName(middleName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setBirthDate(birthDate);
        employee.setPosition(position);
        try {
            employee.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeRepo.save(employee);
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> employeeDTOList =new ArrayList<EmployeeDTO>();
        List<Employee> employeeList =employeeRepo.findAll();
        for (Employee employee: employeeList) {
            EmployeeDTO employeeDTO =new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setSecondName(employee.getSecondName());
            employeeDTO.setMiddleName(employee.getMiddleName());
            employeeDTO.setPhone(employee.getPhone());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setBirthDate(employee.getBirthDate());
            employeeDTO.setPosition(employee.getPosition());
            String image = Base64.getEncoder().encodeToString(employee.getImage());
            employeeDTO.setImage(image);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

//    public List<Employee> findAll() {
//        return employeeRepo.findAll();
//    }


}

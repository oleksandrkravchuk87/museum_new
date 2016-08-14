package ok.service;

import ok.dto.EmployeeDTO;
import ok.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface EmployeeService {
    void addOrEdit(Employee employee);
    void edit(int id, String name, String secondName, String middleName, String phone, String email, String birthDate, String position, MultipartFile multipartFile);
    void delete(int id);

    Employee findOne(int id);

    //   List<Employee> findAll();
    void addOrEdit(String name, String secondName, String middleName, String phone, String email, String birthDate, String position, MultipartFile multipartFile);

    List<EmployeeDTO> findAll();
}

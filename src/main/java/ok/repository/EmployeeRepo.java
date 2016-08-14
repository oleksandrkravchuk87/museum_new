package ok.repository;

import ok.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OKK on 07.08.2016.
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

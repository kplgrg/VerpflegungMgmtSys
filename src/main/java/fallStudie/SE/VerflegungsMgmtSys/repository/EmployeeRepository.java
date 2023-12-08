package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fallStudie.SE.VerflegungsMgmtSys.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

package fallStudie.SE.VerflegungsMgmtSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.Employee;
import fallStudie.SE.VerflegungsMgmtSys.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	public List<Employee> getEmployeeList(){
		return empRepo.findAll();
				
	}
	
	public Employee getEmployeebyId(Long id) {
		return empRepo.findById(id).get();
	}
	

}

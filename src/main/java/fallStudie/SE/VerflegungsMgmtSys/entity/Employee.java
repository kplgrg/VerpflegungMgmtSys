package fallStudie.SE.VerflegungsMgmtSys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private Long employeeId;
	private String employeeName;
	private String email;
	private String department;
	
	
	public Employee(Long employeeId, String employeeName, String email, String department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
	}
	public Employee(String employeeName, String email, String department) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
	}
	public Employee() {
		super();
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}

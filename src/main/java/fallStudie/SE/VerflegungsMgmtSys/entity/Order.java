package fallStudie.SE.VerflegungsMgmtSys.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_head")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_head_sequence", allocationSize = 1, initialValue = 1)
	private Long orderID;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column
	private LocalDate createdDate;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "costcenterid")
	private CostCenter costCenter;

	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "menuID")
	private Menu menu;

	public Order() {
		super();
	}

	public Order(Long orderID, LocalDate date, LocalDate createdDate, LocalTime startTime, LocalTime endTime,
			Employee employee, String remarks, int quantity, CostCenter costCenter, Room room, Menu menu) {
		super();
		this.orderID = orderID;
		this.date = date;
		this.createdDate = createdDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.employee = employee;
		this.remarks = remarks;
		this.quantity = quantity;
		this.costCenter = costCenter;
		this.room = room;
		this.menu = menu;
	}

	public Order(LocalDate date, LocalDate createdDate, LocalTime startTime, LocalTime endTime, Employee employee,
			String remarks, int quantity, CostCenter costCenter, Room room, Menu menu) {
		super();
		this.date = date;
		this.createdDate = createdDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.employee = employee;
		this.remarks = remarks;
		this.quantity = quantity;
		this.costCenter = costCenter;
		this.room = room;
		this.menu = menu;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	


}

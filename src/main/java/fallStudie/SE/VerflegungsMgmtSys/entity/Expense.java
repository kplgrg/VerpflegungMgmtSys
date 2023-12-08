package fallStudie.SE.VerflegungsMgmtSys.entity;

import java.time.Month;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monthlyexp_seq")
	@SequenceGenerator(name = "monthlyexp_seq", sequenceName = "monthlyexp_sequence", allocationSize = 1, initialValue = 1)
	private Long expenseID;
	
	@ManyToOne
	private CostCenter costCenter;
	
	private double expense;
	
	private Month month;
	
	private int year;

	public Expense(Long expenseID, CostCenter costCenter, double expense, Month month, int year) {
		super();
		this.expenseID = expenseID;
		this.costCenter = costCenter;
		this.expense = expense;
		this.month = month;
		this.year = year;
	}

	public Expense(CostCenter costCenter, double expense, Month month, int year) {
		super();
		this.costCenter = costCenter;
		this.expense = expense;
		this.month = month;
		this.year = year;
	}

	public Expense() {
		super();
	}

	public Long getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(Long expenseID) {
		this.expenseID = expenseID;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}

package fallStudie.SE.VerflegungsMgmtSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.Expense;
import fallStudie.SE.VerflegungsMgmtSys.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expRepo;
	
	@Autowired
	public ExpenseService(ExpenseRepository expRepo) {
		this.expRepo = expRepo;
	}

	public Expense saveExpense(Expense expense) {
		return expRepo.save(expense);
	}
	
	public List<Expense> getExpenseList(){
		return expRepo.findAll();
				
	}
	
	public Expense getExpensebyID(Long id) {
		return expRepo.findById(id).get();
	}
	
}

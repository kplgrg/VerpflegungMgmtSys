package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fallStudie.SE.VerflegungsMgmtSys.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}

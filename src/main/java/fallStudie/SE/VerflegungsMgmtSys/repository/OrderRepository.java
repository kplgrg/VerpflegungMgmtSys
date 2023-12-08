package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fallStudie.SE.VerflegungsMgmtSys.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}

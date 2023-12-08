package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fallStudie.SE.VerflegungsMgmtSys.entity.CostCenter;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {

}

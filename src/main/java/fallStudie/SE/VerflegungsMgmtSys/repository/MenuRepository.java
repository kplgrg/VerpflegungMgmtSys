package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fallStudie.SE.VerflegungsMgmtSys.entity.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}

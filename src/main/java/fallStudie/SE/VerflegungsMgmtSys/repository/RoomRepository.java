package fallStudie.SE.VerflegungsMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fallStudie.SE.VerflegungsMgmtSys.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}

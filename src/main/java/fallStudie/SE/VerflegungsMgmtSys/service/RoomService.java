package fallStudie.SE.VerflegungsMgmtSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.Room;
import fallStudie.SE.VerflegungsMgmtSys.repository.RoomRepository;

@Service
public class RoomService {
	
	private final RoomRepository roomRepo;
	
	@Autowired
	public RoomService(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}

	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public List<Room> getRoomList(){
		return roomRepo.findAll();
				
	}
	
	public Room getRoombyID(Long id) {
		return roomRepo.findById(id).get();
	}
	
	public Room updateRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public void deleteRoombyId(Long id) {
		roomRepo.deleteById(id);
	}
}

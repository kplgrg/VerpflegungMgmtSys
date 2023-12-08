package fallStudie.SE.VerflegungsMgmtSys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
	@SequenceGenerator(name = "room_seq", sequenceName = "room_sequence", allocationSize = 1, initialValue = 1)
	@Column(name="roomid")
	private Long roomid;
	private String roomName;
	private String description;
	
	public Room() {
		super();
	}

	public Room(String roomName, String description) {
		super();
		this.roomName = roomName;
		this.description = description;
	}
	
	public Room(Long roomid, String roomName, String description) {
		super();
		this.roomid = roomid;
		this.roomName = roomName;
		this.description = description;
	}
	
	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}

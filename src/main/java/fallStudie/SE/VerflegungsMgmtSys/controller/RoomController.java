package fallStudie.SE.VerflegungsMgmtSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.entity.Room;
import fallStudie.SE.VerflegungsMgmtSys.service.OrderService;
import fallStudie.SE.VerflegungsMgmtSys.service.RoomService;

@Controller
public class RoomController {

	private final RoomService roomService;
	private final OrderService orderService;
	

	@Autowired
	public RoomController(RoomService roomService, OrderService orderService) {
		this.roomService = roomService;
		this.orderService = orderService;
	}


//	Administrator page with Entity 'Room'
	
	@GetMapping("/room_admin")
	public ModelAndView getRoomList() {
		List<Room> list = roomService.getRoomList();
		return new ModelAndView("room_admin", "room", list);
	}

//  *********** CRUD Operations for Table 'Room' ********************************************8

	@PostMapping("/saveRoom")
	public String saveRoom(@ModelAttribute Room room) {
		roomService.saveRoom(room);
		return "redirect:/room_admin";
	}

	@GetMapping("/createRoom")
	public String createRoom(Model model) {
		model.addAttribute("room", new Room());
		return "createRoom";
	}

	@GetMapping("/room/edit/{id}")
	public String editRoom(@PathVariable Long id, Model model) {
		model.addAttribute("room", roomService.getRoombyID(id));
		return "updateRoom";
	}

	@PostMapping("/room/{id}")
	public String updateRoom(@PathVariable Long id, @ModelAttribute("room") Room room) {

		Room updateRoom = roomService.getRoombyID(id);
		updateRoom.setRoomName(room.getRoomName());
		updateRoom.setDescription(room.getDescription());

		roomService.updateRoom(updateRoom);
		return "redirect:/room_admin";
	}

	@GetMapping("/room/{id}")
	public String deleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		
		List<Order> orderList = orderService.getOrderList();
		boolean menuUsed = false;
		for (Order order:orderList) {
			if(roomService.getRoombyID(id).equals(order.getRoom())){
				menuUsed = true;
			}
		}
		if (menuUsed == false) {
			

			roomService.deleteRoombyId(id);
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Cannot delete. The room is saved in one or more orders.");
		}
		return "redirect:/room_admin";
	}
}

package fallStudie.SE.VerflegungsMgmtSys.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fallStudie.SE.VerflegungsMgmtSys.entity.CostCenter;
import fallStudie.SE.VerflegungsMgmtSys.entity.Employee;
import fallStudie.SE.VerflegungsMgmtSys.entity.Expense;
import fallStudie.SE.VerflegungsMgmtSys.entity.Menu;
import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.entity.Room;
import fallStudie.SE.VerflegungsMgmtSys.service.CostCenterService;
import fallStudie.SE.VerflegungsMgmtSys.service.EmployeeService;
import fallStudie.SE.VerflegungsMgmtSys.service.ExpenseService;
import fallStudie.SE.VerflegungsMgmtSys.service.MenuService;
import fallStudie.SE.VerflegungsMgmtSys.service.OrderService;
import fallStudie.SE.VerflegungsMgmtSys.service.RoomService;

@Controller
public class OrderController {

	private final OrderService orderService;
	private final RoomService roomService;
	private final CostCenterService ccService;
	private final MenuService menuService;
	private final EmployeeService empService;
	private final ExpenseService expService;

	@Autowired
	public OrderController(OrderService orderService, RoomService roomService, CostCenterService ccService,
			MenuService menuService, EmployeeService empService, ExpenseService expService) {
		super();
		this.orderService = orderService;
		this.roomService = roomService;
		this.ccService = ccService;
		this.menuService = menuService;
		this.empService = empService;
		this.expService = expService;
	}

//	Order page
	@GetMapping("/order")
	public String orderPage(Model model) {
		List<Room> rooms = roomService.getRoomList();
		List<CostCenter> costCenters = ccService.getCostCenterList();
		List<Menu> menus = menuService.getMenuList();

		model.addAttribute("createOrder", new Order());
		model.addAttribute("costCenters", costCenters);
		model.addAttribute("menus", menus);
		model.addAttribute("rooms", rooms);
		return "orderPage";
	}

//  *********** CRUD Operations for Table 'Order_Head' ********************************************

	@PostMapping("/saveOrder")
	public ModelAndView saveOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {

		LocalDate currentDate = LocalDate.now();
		order.setCreatedDate(currentDate);
		List<Employee> employeeList = empService.getEmployeeList();
		List<Order> orderList = orderService.getOrderList();
		Expense expense = new Expense();

		for (Employee employee : employeeList) {
			if (order.getEmployee() != employee) {
				redirectAttributes.addFlashAttribute("errorMessage", "Employee ID does not exist!");
				return new ModelAndView("redirect:/order");
			}
		}
		if (order.getDate().isBefore(currentDate)) {
			redirectAttributes.addFlashAttribute("errorMessage", "Date has already passed.");
			return new ModelAndView("redirect:/order");
		}
		for (Order item : orderList) {
			if (order.getDate().equals(item.getDate()) && order.getRoom().equals(item.getRoom())) {
				if (order.getStartTime().isAfter(item.getStartTime())
						&& order.getStartTime().isBefore(item.getEndTime())) {
					redirectAttributes.addFlashAttribute("errorMessage",
							"Room is not available for given date and time period. Please choose another time period.");
					return new ModelAndView("redirect:/order");
			}
		}
		}
		
		expense.setCostCenter(order.getCostCenter());
		expense.setMonth(order.getDate().getMonth());
		expense.setYear(order.getDate().getYear());
		expense.setExpense(order.getMenu().getPrice()*order.getQuantity());
		expService.saveExpense(expense);
		orderService.saveOrder(order);
		return new ModelAndView("orderSuccess", "order", order);
	}
	
	@GetMapping("/orderSuccess")
	public String orderConfirmationPage() {
		return "orderSuccess";
	}

}

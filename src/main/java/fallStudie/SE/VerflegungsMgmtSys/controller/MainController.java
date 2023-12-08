package fallStudie.SE.VerflegungsMgmtSys.controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fallStudie.SE.VerflegungsMgmtSys.entity.CostCenter;
import fallStudie.SE.VerflegungsMgmtSys.entity.Expense;
import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.service.CostCenterService;
import fallStudie.SE.VerflegungsMgmtSys.service.ExpenseService;
import fallStudie.SE.VerflegungsMgmtSys.service.OrderService;

@Controller
public class MainController {

	private final OrderService orderService;
	private final CostCenterService ccService;
	private final ExpenseService expService;

	@Autowired
	public MainController(OrderService orderService, CostCenterService ccService, ExpenseService expService) {
		super();
		this.orderService = orderService;
		this.ccService = ccService;
		this.expService = expService;
	}
	
	
//	Mapping for Main pages of Web application

//	Homepage
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

//	Menu page
	@GetMapping("/menu")
	public String menuPage() {
		return "menuPage";
	}

//	Order by CostCenter Page
	
	@GetMapping("/orderByCostCenter")
	public String reportCCPage(Model model) {
		int currentYear = Year.now().getValue();
		List<CostCenter> costCenterList = ccService.getCostCenterList();
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("costCenters", costCenterList);
		return "reportCostCenter";
	}


	@PostMapping("/orderByCostCenter")
	public ModelAndView orderByCostCenter(@RequestParam("costCenter") CostCenter costCenter,
			@RequestParam("year") Integer year, Model model, RedirectAttributes redirectAttributes) {
		List<CostCenter> costCenterList = ccService.getCostCenterList();
		List<Expense> expenseList = expService.getExpenseList();
		List<Order> orderList = orderService.getOrderList();
		List<Order> searchResults = new ArrayList<>();
		int currentYear = Year.now().getValue();
		double jan = 0 ,
				feb = 0,
				mar = 0,
				apr = 0,
				may = 0,
				jun = 0,
				jul = 0,
				aug = 0,
				sep = 0,
				oct = 0,
				nov = 0,
				dec = 0;
		
//		To show list of orders assigned to selected Cost center
		
		for(Order order: orderList ) {
			int orderYear = order.getDate().getYear();
			if (order.getCostCenter().equals(costCenter) && orderYear == year ) {
				searchResults.add(order);
			}
		}

//		To show bar graph for costs assigned to a Cost center
		
		for (Expense item : expenseList) {
			int orderYear = item.getYear();
			
//			Adds expense to respective months based on when orders were made for
			if (item.getCostCenter().getCostcenterid().equals(costCenter.getCostcenterid()) && orderYear == year) {
				switch(item.getMonth()) {
				case JANUARY:
					jan += item.getExpense();
					break;
				case FEBRUARY:
					feb += item.getExpense();
					break;
				case MARCH:
					mar += item.getExpense();
					break;
				case APRIL:
					apr += item.getExpense();
					break;
				case MAY:
					may += item.getExpense();
					break;
				case JUNE:
					jun += item.getExpense();
					break;
				case JULY:
					jul += item.getExpense();
					break;
				case AUGUST:
					aug += item.getExpense();
					break;
				case SEPTEMBER:
					sep += item.getExpense();
					break;
				case OCTOBER:
					oct += item.getExpense();
					break;
				case NOVEMBER:
					nov += item.getExpense();
					break;
				case DECEMBER:
					dec += item.getExpense();
					break;	
				}		
			}
		}
		
		List<Double> expense = new ArrayList<>(Arrays.asList(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec));

		model.addAttribute("expense", expense);  // expense is assigned to javascript as data for bar graph
		model.addAttribute("currentYear", currentYear);  // provides year select options upto current year back to view
		model.addAttribute("costCenters", costCenterList); // provides cost center select options back to view

		return new ModelAndView("reportCostCenter", "searchResults", searchResults);
	}

	
	@GetMapping("/orderByDate")
	public String orderByDate() {
		return "reportbyDate";
	}

	@PostMapping("/orderByDate")
	public ModelAndView orderByDate(@RequestParam("selectedDate") LocalDate selectedDate, Model model) {
		List<Order> searchResults = orderService.orderbyDate(selectedDate);
		model.addAttribute("order", searchResults);

		return new ModelAndView("reportbyDate", "order", searchResults); // provides searchResults back to view 
	}

	@GetMapping("/reportToday")
	public ModelAndView reportToday() {
		LocalDate today = LocalDate.now();
		List<Order> orderList = orderService.orderbyDate(today);
		return new ModelAndView("todayReport", "order", orderList); // provides list of orders for current day back to view
	}

};

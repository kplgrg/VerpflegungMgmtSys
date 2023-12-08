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

import fallStudie.SE.VerflegungsMgmtSys.entity.CostCenter;
import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.service.CostCenterService;
import fallStudie.SE.VerflegungsMgmtSys.service.OrderService;


@Controller
public class CostCenterController {
	private final CostCenterService ccService;
	private final OrderService orderService;
	
	
	@Autowired
	public CostCenterController(CostCenterService ccService, OrderService orderService) {

		this.ccService = ccService;
		this.orderService = orderService;
	}

	// Administrator page with Entity 'CostCenter'
	
	@GetMapping("/costcenter_admin")
	public ModelAndView getCostCenterList() {
		List<CostCenter> list = ccService.getCostCenterList();
		return new ModelAndView("costcenter_admin", "costCenter", list);
	}

//  *********** CRUD Operations for Entity 'Cost Center' *********************

	@PostMapping("/saveCostCenter")
	public String saveCostCenter(@ModelAttribute CostCenter costCenter) {
		ccService.saveCostCenter(costCenter);
		return "redirect:/costcenter_admin";
	}

	@GetMapping("/createCostCenter")
	public String createCostCenter(Model model) {
		model.addAttribute("costCenter", new CostCenter());
		return "createCostCenter";
	}
	
	@GetMapping("/costCenter/edit/{id}")
	public String editCostCenter(@PathVariable Long id, Model model) {
		model.addAttribute("costCenter", ccService.getCostCenterbyID(id));
		return "updateCostCenter";
	}

	@PostMapping("/costCenter/{id}")
	public String updateCostCenter(@PathVariable Long id, @ModelAttribute("costCenter") CostCenter costCenter) {

		CostCenter updateCostCenter = ccService.getCostCenterbyID(id);
		updateCostCenter.setCostcenter(costCenter.getCostcenter());
		updateCostCenter.setDescription(costCenter.getDescription());

		ccService.updateCostCenter(updateCostCenter);
		return "redirect:/costcenter_admin";
	}

	@GetMapping("/costCenter/{id}")
	public String deleteCostCenter(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		List<Order> orderList = orderService.getOrderList();
		boolean ccUsed = false;
		for (Order order:orderList) {
			if(ccService.getCostCenterbyID(id).equals(order.getCostCenter())){
				ccUsed = true;
			}
		}
		if (ccUsed == false) {
			
			ccService.deleteCostCenterbyId(id);
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Cannot delete. The Cost Center is saved in one or more orders.");
		}
		return "redirect:/costcenter_admin";
	}

}

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

import fallStudie.SE.VerflegungsMgmtSys.entity.Menu;
import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.service.MenuService;
import fallStudie.SE.VerflegungsMgmtSys.service.OrderService;

@Controller
public class MenuController {

	private final MenuService menuService;
	private final OrderService orderService;
	

	@Autowired
	public MenuController(MenuService menuService, OrderService orderService) {
		this.menuService = menuService;
		this.orderService = orderService;
	}



//	Admin page with Table 'Menu'
//	Landing page of administrator  with list of menu
	@GetMapping("/admin")
	public ModelAndView getMenuList() {
		List<Menu> list = menuService.getMenuList();
		return new ModelAndView("admin", "menu", list);
	}

//  *********** CRUD Operations for Table 'Menu' ********************************************8

	@PostMapping("/saveMenu")
	public String saveMenu(@ModelAttribute Menu menu) {
		menuService.saveMenu(menu);
		return "redirect:/admin";
	}

	@GetMapping("/createMenu")
	public String createMenu(Model model) {
		model.addAttribute("menu", new Menu());
		return "createMenu";
	}

	@GetMapping("/menu/edit/{id}")
	public String editMenu(@PathVariable Long id, Model model) {
		model.addAttribute("menu", menuService.getMenubyID(id));
		return "updateMenu";
	}

	@PostMapping("/menu/{id}")
	public String updateMenu(@PathVariable Long id, @ModelAttribute("menu") Menu menu) {

		Menu existingMenu = menuService.getMenubyID(id);
		existingMenu.setName(menu.getName());
		existingMenu.setDescription(menu.getDescription());
		existingMenu.setPrice(menu.getPrice());

		menuService.updateMenu(existingMenu);
		return "redirect:/admin";
	}

	@GetMapping("/menu/{id}")
	public String deleteMenu(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
		List<Order> orderList = orderService.getOrderList();
		boolean menuUsed = false;
		for (Order order:orderList) {
			if(menuService.getMenubyID(id).equals(order.getMenu())){
				menuUsed = true;
			}
		}
		if (menuUsed == false) {
			
			menuService.deleteMenubyId(id);
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage",
					"Cannot delete. The menu is saved in one or more orders.");
		}
		return "redirect:/admin";
	}


}

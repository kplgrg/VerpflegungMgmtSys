package fallStudie.SE.VerflegungsMgmtSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.Menu;
import fallStudie.SE.VerflegungsMgmtSys.repository.MenuRepository;

@Service
public class MenuService {
	
	private final MenuRepository menuRepo;
	
	@Autowired
	public MenuService(MenuRepository menuRepo) {
		this.menuRepo = menuRepo;
	}

	public Menu saveMenu(Menu menu) {
		return menuRepo.save(menu);
	}
	
	public List<Menu> getMenuList(){
		return menuRepo.findAll();
				
	}
	
	public Menu getMenubyID(Long id) {
		return menuRepo.findById(id).get();
	}
	
	public Menu updateMenu(Menu menu) {
		return menuRepo.save(menu);
	}
	
	public void deleteMenubyId(Long id) {
		menuRepo.deleteById(id);
	}
}

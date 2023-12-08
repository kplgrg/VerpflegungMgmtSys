package fallStudie.SE.VerflegungsMgmtSys.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fallStudie.SE.VerflegungsMgmtSys.repository.CostCenterRepository;
import fallStudie.SE.VerflegungsMgmtSys.repository.EmployeeRepository;
import fallStudie.SE.VerflegungsMgmtSys.repository.MenuRepository;
import fallStudie.SE.VerflegungsMgmtSys.repository.RoomRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	

	private final EmployeeRepository empRepo;
	private final MenuRepository menuRepo;
	private final RoomRepository roomRepo;
	private final CostCenterRepository ccRepo;
	
	

	@Autowired
	public DataSeeder(EmployeeRepository empRepo, MenuRepository menuRepo, RoomRepository roomRepo,
			CostCenterRepository ccRepo) {
		super();
		this.empRepo = empRepo;
		this.menuRepo = menuRepo;
		this.roomRepo = roomRepo;
		this.ccRepo = ccRepo;
	}


	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee(1L,"Mustermann","mustermann@gmail.com","Marketing" );
		empRepo.save(emp1);
		
		Menu menu1 = new Menu(1L,"Light","Kaffee & Kekse", 2.99);
		Menu menu2 = new Menu(2L,"Medium","Kaffee, Tee, Wasser, Keksen & Kuchen", 6.99);
		Menu menu3 = new Menu(3L,"Large", "Kaffee, Brötchen & Omelett", 9.99);
		menuRepo.saveAll(List.of(menu1,menu2,menu3));
		
		Room room1 = new Room(1L,"Conference", "Building 1 - Ground floor");
		Room room2 = new Room(2L, "Meeting Hall","Building 2 - Third floor");
		roomRepo.saveAll(List.of(room1,room2));
		
		CostCenter cc1 = new CostCenter(1L,"MKT001", "Marketing");
		CostCenter cc2 = new CostCenter(2L,"FIBU001", "Finance and Accounting");
		ccRepo.saveAll(List.of(cc1,cc2));
		
		
	}

}

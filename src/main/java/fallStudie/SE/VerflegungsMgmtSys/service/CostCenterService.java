package fallStudie.SE.VerflegungsMgmtSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.CostCenter;
import fallStudie.SE.VerflegungsMgmtSys.repository.CostCenterRepository;

@Service
public class CostCenterService {
	
	private final CostCenterRepository ccRepo;
	
	@Autowired
	public CostCenterService(CostCenterRepository ccRepo) {
		this.ccRepo = ccRepo;
	}

	public CostCenter saveCostCenter(CostCenter costcenter) {
		return ccRepo.save(costcenter);
	}
	
	public List<CostCenter> getCostCenterList(){
		return ccRepo.findAll();
				
	}
	
	public CostCenter getCostCenterbyID(Long id) {
		return ccRepo.findById(id).get();
	}

	
	public CostCenter updateCostCenter(CostCenter costcenter) {
		return ccRepo.save(costcenter);
	}
	
	public void deleteCostCenterbyId(Long id) {
		ccRepo.deleteById(id);
	}
}

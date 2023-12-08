package fallStudie.SE.VerflegungsMgmtSys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "costcenter")
public class CostCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costcenter_seq")
	@SequenceGenerator(name = "costcenter_seq", sequenceName = "costcenter_sequence", allocationSize = 1, initialValue = 1)
	private Long costcenterid;
	private String costcenter;
	private String description;

	public CostCenter() {
		super();
	}
	
	public CostCenter(String costcenter, String description) {
		super();
		this.costcenter = costcenter;
		this.description = description;
	}

	public CostCenter(Long costcenterid, String costcenter, String description) {
		super();
		this.costcenterid = costcenterid;
		this.costcenter = costcenter;
		this.description = description;
	}

	public Long getCostcenterid() {
		return costcenterid;
	}

	public void setCostcenterid(Long costcenterid) {
		this.costcenterid = costcenterid;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

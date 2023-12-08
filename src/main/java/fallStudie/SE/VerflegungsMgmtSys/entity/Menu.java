package fallStudie.SE.VerflegungsMgmtSys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
	@SequenceGenerator(name = "menu_seq", sequenceName = "menu_sequence", allocationSize = 1, initialValue = 1)
	private Long menuID;
	
	@Column(
			name="name", nullable = false
			)
	private String name;
	
	@Column(
			name="description", nullable = false
			)
	private String description;
	
	@Column(
			name="price", nullable = false
			)
	private double price;

	public Menu() {
		super();
	}
	
	public Menu(Long menuID, String name, String description, double price) {
		this.menuID = menuID;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Menu(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}


	public Long getMenuID() {
		return menuID;
	}
	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}

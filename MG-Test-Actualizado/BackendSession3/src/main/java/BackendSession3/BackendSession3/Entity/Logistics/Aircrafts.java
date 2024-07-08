package BackendSession3.BackendSession3.Entity.Logistics;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Aircrafts")
public class Aircrafts extends BaseEntity {
	
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "make_model", length = 50)
	private String makeModel;
	
	@Column(name = "total_seats")
	private Integer totalSeats;
	
	@Column(name = "economy_seats")
	private Integer economySeats;
	
	@Column(name = "business_seats")
	private Integer businessSeats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMakeModel() {
		return makeModel;
	}

	public void setMakeModel(String makeModel) {
		this.makeModel = makeModel;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(Integer economySeats) {
		this.economySeats = economySeats;
	}

	public Integer getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}
	
	

	

}

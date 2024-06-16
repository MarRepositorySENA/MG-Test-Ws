package BackendSession3.BackendSession3.Entity.Operational;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import BackendSession3.BackendSession3.Entity.Parameter.Countries;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Airports")
public class Airports extends BaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "country_id", nullable = false, unique = true)
	private Countries countryId;
	
	@Column(name = "iata_code ", length = 10)
	private String iataCode;
	
	@Column(name = "name ", length = 10)
	private String name;

	public Airports(Countries countryId, String iataCode, String name) {
		super();
		this.countryId = countryId;
		this.iataCode = iataCode;
		this.name = name;
	}

	public Countries getCountryId() {
		return countryId;
	}

	public void setCountryId(Countries countryId) {
		this.countryId = countryId;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}

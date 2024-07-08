package BackendSession3.BackendSession3.Entity.Sales;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CabinTypes")
public class CabinTypes extends BaseEntity{
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

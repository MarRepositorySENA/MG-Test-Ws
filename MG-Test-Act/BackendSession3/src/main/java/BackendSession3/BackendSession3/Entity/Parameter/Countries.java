package BackendSession3.BackendSession3.Entity.Parameter;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Countries")
public class Countries extends BaseEntity{

	@Column(name = "name", length = 45, nullable = false)
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

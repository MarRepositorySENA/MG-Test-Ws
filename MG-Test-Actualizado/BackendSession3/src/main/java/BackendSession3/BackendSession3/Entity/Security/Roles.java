package BackendSession3.BackendSession3.Entity.Security;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Roles")
public class Roles extends BaseEntity{

	@Column(name = "title", length =45, nullable = false)
	private String title;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

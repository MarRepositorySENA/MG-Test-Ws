package BackendSession3.BackendSession3.Entity.Sales;



import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;
import BackendSession3.BackendSession3.Entity.Parameter.Countries;
import BackendSession3.BackendSession3.Entity.Security.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Tickets")
public class Tickets extends BaseEntity {
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private Users userId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "shedule_id", nullable = false, unique = true)
	private Shedules sheduleId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cabin_type_id", nullable = false, unique = true)
	private CabinTypes cabinTypeId;
	
	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;

	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "phone", length = 20, nullable = false)
	private String phone;
	
	@Column(name = "passport_number", length = 50, nullable = false)
	private String passport_number;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "passport_country_id", nullable = false, unique = true)
	private Countries passportCountryId;
	
	@Column(name = "passport_photo", length = 50, nullable = false)
	private Long passportPhoto;
	
	@Column(name = "booking_reference", length = 50)
	private String booking_reference;
	
	@Column(name = "confirmed", length = 50, nullable=false)
	private Boolean confirmed;

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Shedules getSheduleId() {
		return sheduleId;
	}

	public void setSheduleId(Shedules sheduleId) {
		this.sheduleId = sheduleId;
	}

	public CabinTypes getCabinTypeId() {
		return cabinTypeId;
	}

	public void setCabinTypeId(CabinTypes cabinTypeId) {
		this.cabinTypeId = cabinTypeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public Countries getPassportCountryId() {
		return passportCountryId;
	}

	public void setPassportCountryId(Countries passportCountryId) {
		this.passportCountryId = passportCountryId;
	}

	public Long getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(Long passportPhoto) {
		this.passportPhoto = passportPhoto;
	}

	public String getBooking_reference() {
		return booking_reference;
	}

	public void setBooking_reference(String booking_reference) {
		this.booking_reference = booking_reference;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	
}

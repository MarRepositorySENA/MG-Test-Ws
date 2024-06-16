package BackendSession3.BackendSession3.Entity.Logistics;

import java.time.Duration;

import BackendSession3.BackendSession3.Entity.BaseEntity.BaseEntity;
import BackendSession3.BackendSession3.Entity.Operational.Airports;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Routes")
public class Routes extends BaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "departure_airport_id", nullable = false, unique = true)
	private Airports departureAirportId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "arrival_airport_id", nullable = false, unique = true)
	private Airports arrivalAirportId;
	
	@Column(name = "distance")
	private Integer distance;
	
	@Column(name = "flight_time")
	private Duration flight_time;

	public Routes(Airports departureAirportId, Airports arrivalAirportId, Integer distance, Duration flight_time) {
		super();
		this.departureAirportId = departureAirportId;
		this.arrivalAirportId = arrivalAirportId;
		this.distance = distance;
		this.flight_time = flight_time;
	}

	public Airports getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(Airports departureAirportId) {
		this.departureAirportId = departureAirportId;
	}

	public Airports getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(Airports arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Duration getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(Duration flight_time) {
		this.flight_time = flight_time;
	}
	
	
	
	
}

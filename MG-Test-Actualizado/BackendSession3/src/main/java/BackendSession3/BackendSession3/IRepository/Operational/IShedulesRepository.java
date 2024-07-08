package BackendSession3.BackendSession3.IRepository.Operational;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Dto.IFiltroReservaDto;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface IShedulesRepository extends IBaseRepository<Shedules, Long> {

	
	@Query(value =  "SELECT  "
            + "      sch.id AS id,          "
            + "    air1.name AS origen, "
            + "    air2.name AS destino, "
            + "    sch.date AS fecha, "
            + "    sch.time AS hora, "
            + "    sch.flight_number AS numeroVuelo, "
            + "    CASE "
            + "      WHEN :tipoCabina = 'economica' THEN airc.economy_seats "
            + "      WHEN :tipoCabina = 'ejecutiva' THEN airc.business_seats * 1.35 "
            + "      WHEN :tipoCabina = 'primera' THEN airc.business_seats * 1.35 * 1.30 "
            + "    END AS precioCabina,  "
            + "    airc.business_seats, "
            + "    airc.total_seats, "
            + "    sch.aircraft_id "
            + "FROM  "
            + "    Schedules AS sch "
            + "INNER JOIN  "
            + "    Routes AS rou ON sch.route_id = rou.id "
            + "INNER JOIN  "
            + "    Aircrafts AS airc ON sch.aircraft_id = airc.id "
            + "INNER JOIN  "
            + "    Airports AS air1 ON air1.id = rou.departure_airport_id "
            + "INNER JOIN  "
            + "    Airports AS air2 ON air2.id = rou.arrival_airport_id "
            + "WHERE  "
            + "   rou.departure_airport_id = :origen "
            + "    AND rou.arrival_airport_id = :destino "
            + "    AND ( "
            + "            :tres = FALSE AND sch.date = :fecha  "
            + "            OR  "
            + "            :tres = TRUE AND sch.date BETWEEN DATE_SUB(:fecha, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY)  "
            + "          )",  nativeQuery = true)
List<IFiltroReservaDto> getFiltroSalida(@Param("origen") int origen, 
                                        @Param("destino") int destino,
                                        @Param("fecha") Date fecha,
                                        @Param("tres") Boolean tres,
                                        @Param("tipoCabina") String tipoCabina);


	
	@Query(value =  "SELECT  "
			+"      sch.id AS id,          "
	        + "    coun1.name AS origen, "
	        + "    coun2.name AS destino, "
	        + "    sch.date AS fecha, "
	        + "    sch.time AS hora, "
	        + "    sch.flight_number AS numeroVuelo, "
	        + "    airc.economy_seats AS precioCabina,  "
	        + "    airc.business_seats, "
	        + "    airc.total_seats, "
	        + "    sch.aircraft_id "
	        + "FROM  "
	        + "   	Shedules AS sch "
	        + "INNER JOIN  "
	        + "    Routes AS rou ON sch.route_id = rou.id "
	        + "INNER JOIN  "
	        + "    Aircrafts AS airc ON sch.aircraft_id = airc.id "
	        + "INNER JOIN  "
	        + "    Airports AS air1 ON air1.id = rou.departure_airport_id "
	        + "INNER JOIN  "
	        + "    Airports AS air2 ON air2.id = rou.arrival_airportid "
	        + "INNER JOIN  "
	        + "    Countries AS coun1 ON air1.country_id = coun1.id "
	        + "INNER JOIN  "
	        + "    Countries AS coun2 ON air2.country_id = coun2.id "
	        + "WHERE  "
	        + "   rou.departure_airport_id = :destino "
	        + "    AND rou.arrival_airport_id = :origen "
	        + "      AND ( "
            + "            :tres = FALSE AND sch.date = :fecha  "
            + "            OR  "
            + "            :tres = TRUE AND sch.date BETWEEN DATE_SUB(:fecha, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY)  "
            + "          )",  nativeQuery = true )
	
    List<IFiltroReservaDto> getFiltroRetorno(@Param("origen") int origen, 
                                      @Param("destino") int destino,
                                      @Param("fecha") Date fecha,
                                      @Param("tres") Boolean tres
                                      );

	

}

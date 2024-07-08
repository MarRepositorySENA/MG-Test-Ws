package BackendSession3.BackendSession3.Controller.Operational;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Dto.FiltroReservaDto;
import BackendSession3.BackendSession3.Dto.IFiltroReservaDto;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;
import BackendSession3.BackendSession3.Service.Operational.ShedulesService;
import BackendSession3.BackendSession3.Util.ApiResponseDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Operational/Shedules/")
public class SheduleController extends BaseController<Shedules>{
	
	@Autowired
	private ShedulesService service;
	
	@PostMapping("/Filtro-Ida")
	public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtroIda(@RequestBody FiltroReservaDto filtro) {
	    try {
	        if (filtro.getFecha() == null || filtro.getFecha().isEmpty()) {
	            throw new IllegalArgumentException("La fecha no puede ser nula o vacía");
	        }
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.sql.Date fechaDestino = new java.sql.Date(dateFormat.parse(filtro.getFecha()).getTime());

	        System.out.println("Controlador - Origen: " + filtro.getOrigen() + ", Destino: " + filtro.getDestino() + ", Fecha: " + fechaDestino + ", TresDias: " + filtro.getTresDias());

	        List<IFiltroReservaDto> result = service.getIda(filtro.getOrigen(), filtro.getDestino(), fechaDestino, filtro.getTresDias());
	        return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result, true));
	    } catch (Exception e) {
	        e.printStackTrace(); // Para imprimir la traza del error en los logs
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
	    }
	}


			//filtro solo retorno
		@PostMapping("/Filtro-Retorno")
	    public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtroRetorno(@RequestBody FiltroReservaDto filtro) {
	        try {
	        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        java.sql.Date fecha = new java.sql.Date(dateFormat.parse(filtro.getFecha()).getTime());
		        List<IFiltroReservaDto>   result= service.getRetorno(filtro.getOrigen(), filtro.getDestino(),fecha,filtro.getTresDiaR());
	            return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result,true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
	        }
	    }
		
		@GetMapping("/Salida")
	    public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> Salida() {
	        try {
	        	
		        List<IFiltroReservaDto>   result= service.getSalida();
	            return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result,true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
	        }
	    }

}

package BackendSession3.BackendSession3.Service.Operational;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackendSession3.BackendSession3.Dto.IFiltroReservaDto;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;
import BackendSession3.BackendSession3.IRepository.Operational.IShedulesRepository;
import BackendSession3.BackendSession3.IService.Operational.IShedulesService;
import BackendSession3.BackendSession3.Service.BaseService.BaseService;
@Service
public class ShedulesService extends BaseService<Shedules> implements IShedulesService {

	@Autowired
	public IShedulesRepository repository;
	@Override
	public List<IFiltroReservaDto> getIda(int origen, int destino, Date fecha, Boolean TresDias) throws Exception {
		System.out.println("Servicio - Origen: " + origen + ", Destino: " + destino + ", Fecha: " + fecha);
	    return repository.getFiltroIda(origen, destino, fecha, TresDias);
	}

	@Override
	public List<IFiltroReservaDto> getRetorno(int destino, int origen, Date fecha, Boolean TresDias) throws Exception {
		// TODO Auto-generated method stub
				return repository.getFiltroRetorno(origen, destino, fecha,TresDias);
	}

	@Override
	public List<IFiltroReservaDto> getSalida() {
		// TODO Auto-generated method stub
				return repository.getSalida();
	}

}

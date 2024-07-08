package BackendSession3.BackendSession3.IService.Operational;

import java.sql.Date;
import java.util.List;

import BackendSession3.BackendSession3.Dto.IFiltroReservaDto;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;
import BackendSession3.BackendSession3.IService.IBaseService.IBaseService;

public interface IShedulesService extends IBaseService<Shedules>{
	
List<IFiltroReservaDto> getIda(int origen, int destino, Date fecha,Boolean TresDias) throws Exception;
	
	List<IFiltroReservaDto> getRetorno(int destino,int origen, Date fecha, Boolean TresDias) throws Exception;

	List<IFiltroReservaDto> getSalida();
	

}

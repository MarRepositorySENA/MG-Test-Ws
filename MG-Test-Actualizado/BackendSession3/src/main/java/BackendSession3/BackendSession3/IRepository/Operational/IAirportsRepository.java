package BackendSession3.BackendSession3.IRepository.Operational;

import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Entity.Operational.Airports;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface IAirportsRepository extends IBaseRepository<Airports, Long>{

}

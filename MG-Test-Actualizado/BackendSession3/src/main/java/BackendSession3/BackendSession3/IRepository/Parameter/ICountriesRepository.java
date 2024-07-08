package BackendSession3.BackendSession3.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Entity.Parameter.Countries;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface ICountriesRepository extends IBaseRepository<Countries, Long>{
	

}

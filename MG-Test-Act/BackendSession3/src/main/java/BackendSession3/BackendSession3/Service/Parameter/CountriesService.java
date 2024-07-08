package BackendSession3.BackendSession3.Service.Parameter;

import org.springframework.stereotype.Service;

import BackendSession3.BackendSession3.Entity.Parameter.Countries;
import BackendSession3.BackendSession3.IService.Parameter.ICountriesService;
import BackendSession3.BackendSession3.Service.BaseService.BaseService;
@Service
public class CountriesService extends BaseService<Countries> implements ICountriesService{

}

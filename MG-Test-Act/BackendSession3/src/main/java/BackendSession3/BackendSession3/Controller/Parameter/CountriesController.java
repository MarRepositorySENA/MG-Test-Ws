package BackendSession3.BackendSession3.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Parameter.Countries;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Parameter/Countries/")
public class CountriesController extends BaseController<Countries> {

}

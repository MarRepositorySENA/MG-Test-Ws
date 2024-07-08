package BackendSession3.BackendSession3.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Operational.Airports;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Operational/Airports/")
public class AirportsController extends BaseController<Airports>{

}

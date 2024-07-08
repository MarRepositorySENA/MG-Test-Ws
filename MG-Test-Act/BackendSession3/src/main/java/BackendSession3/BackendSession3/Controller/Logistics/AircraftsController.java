package BackendSession3.BackendSession3.Controller.Logistics;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Logistics.Aircrafts;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Logistics/Aircrafts/")
public class AircraftsController extends BaseController<Aircrafts> {

}

package BackendSession3.BackendSession3.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Parameter.Offices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Parameter/Offices/")
public class OfficesController extends BaseController<Offices> {

}

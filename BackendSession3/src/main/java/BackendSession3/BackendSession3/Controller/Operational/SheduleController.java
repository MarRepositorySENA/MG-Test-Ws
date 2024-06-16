package BackendSession3.BackendSession3.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Operational.Shedules;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Operational/Shedules/")
public class SheduleController extends BaseController<Shedules>{

}

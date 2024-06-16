package BackendSession3.BackendSession3.Controller.Sales;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Sales.CabinTypes;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Sales/CabinTypes/")
public class CabinTypesController extends BaseController<CabinTypes>{

}

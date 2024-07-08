package BackendSession3.BackendSession3.Controller.Sales;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Sales.Tickets;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Sales/Tickets/")
public class TicketsController extends BaseController<Tickets>{

}

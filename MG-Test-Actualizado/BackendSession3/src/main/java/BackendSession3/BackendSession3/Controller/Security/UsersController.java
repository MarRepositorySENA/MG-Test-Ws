package BackendSession3.BackendSession3.Controller.Security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackendSession3.BackendSession3.Controller.BaseController.BaseController;
import BackendSession3.BackendSession3.Entity.Security.Users;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/session3/Security/Users/")
public class UsersController extends BaseController<Users>{

}

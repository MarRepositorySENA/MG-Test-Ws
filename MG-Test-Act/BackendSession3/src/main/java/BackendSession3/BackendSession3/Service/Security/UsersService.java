package BackendSession3.BackendSession3.Service.Security;

import org.springframework.stereotype.Service;

import BackendSession3.BackendSession3.Entity.Security.Users;
import BackendSession3.BackendSession3.IService.Security.IUsersService;
import BackendSession3.BackendSession3.Service.BaseService.BaseService;

@Service
public class UsersService extends BaseService<Users> implements IUsersService{

}

package BackendSession3.BackendSession3.IRepository.Security;

import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Entity.Security.Users;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface IUsersRepository extends IBaseRepository<Users, Long>{

}

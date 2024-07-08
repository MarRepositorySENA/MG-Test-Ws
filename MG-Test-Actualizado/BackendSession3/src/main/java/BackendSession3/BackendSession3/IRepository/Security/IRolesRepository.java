package BackendSession3.BackendSession3.IRepository.Security;

import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Entity.Security.Roles;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface IRolesRepository extends IBaseRepository<Roles, Long>{

}

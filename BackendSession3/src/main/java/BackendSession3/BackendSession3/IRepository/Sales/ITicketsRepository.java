package BackendSession3.BackendSession3.IRepository.Sales;

import org.springframework.stereotype.Repository;

import BackendSession3.BackendSession3.Entity.Sales.Tickets;
import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
@Repository
public interface ITicketsRepository extends IBaseRepository<Tickets, Long>{

}

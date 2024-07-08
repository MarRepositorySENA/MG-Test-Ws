package BackendSession3.BackendSession3.IRepository.BaseRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T,ID> extends JpaRepository<T, Long> {
	
}

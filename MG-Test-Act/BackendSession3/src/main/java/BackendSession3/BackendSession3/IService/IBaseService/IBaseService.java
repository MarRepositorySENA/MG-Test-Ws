package BackendSession3.BackendSession3.IService.IBaseService;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T> {

	List<T> all() throws Exception;

	Optional<T> findById(Long id) throws Exception;

	T save(T instanceEntity) throws Exception;
	
	 void update(Long id, T instanceEntity) throws Exception;

	void delete(Long id) throws Exception;
}

package BackendSession3.BackendSession3.Service.BaseService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import BackendSession3.BackendSession3.IRepository.BaseRepository.IBaseRepository;
import BackendSession3.BackendSession3.IService.IBaseService.IBaseService;
import BackendSession3.BackendSession3.Util.GlobalConstants;

@Service
public abstract class BaseService<T>  implements IBaseService<T>{
	
	@Autowired
	private IBaseRepository<T, Long> repositoryT;

	@Override
	public List<T> all() throws Exception {
		return repositoryT.findAll();	}

	@Override
	public Optional<T> findById(Long id) throws Exception {
		return repositoryT.findById(id);
	}

	@Override 
	public T save(T instanceEntity) throws Exception {
		return repositoryT.save(instanceEntity);
	}

	@Override
	public void update(Long id, T instanceEntity) throws Exception {
		Optional<T> optionalT = this.repositoryT.findById(id);

		if (optionalT.isEmpty()) {
			throw new Exception("No se encontró registro");
		}
		T TobjetoToUpdate = optionalT.get();
		BeanUtils.copyProperties(instanceEntity, TobjetoToUpdate,
				GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

		this.repositoryT.save(TobjetoToUpdate);
		
	}

	@Override
	public void delete(Long id) throws Exception {
		repositoryT.deleteById(id);
		
	}
		
	
}

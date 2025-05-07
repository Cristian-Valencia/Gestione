package sinapsys.gestione.repositories;

import java.util.List;

public interface IRepositoryRead <T> {
	
	T getById(int id);	
	
	List<T> getAll();
	

}

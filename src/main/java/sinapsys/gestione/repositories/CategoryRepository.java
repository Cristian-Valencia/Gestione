package sinapsys.gestione.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;


@Repository
public class CategoryRepository implements IRepositoryRead<Category>, IRepositoryWrite<Category> {
	
	
	@Autowired CategoryRepo repo;
	
	
	@Override
	public List<Category> getAll() {
		
		return repo.findAll();
		
	}
	
	
	@Override
	public Category getById(int id) {
		
		return repo.findById(id).orElse(null);

	}

	
	
	

	@Override
	public boolean Insert(Category obj) {
		
		
		try {
			
			repo.save(obj);
			return true;

			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
			
		}

	}

	@Override
	public boolean Update(Category obj) {
		
		try {
			
			repo.save(obj);
			return true;

			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
			
		}

		
	}

	@Override
	public boolean Delete(int id) {

		
		try {
			
			repo.deleteById(id);			
			return true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}



	
	
	
	

}

package sinapsys.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	public List<Category> catListService(){
		return catRepo.getAll();
	}
	
	public Category catDetailService(int varId) {
		
		return catRepo.getById(varId);
		
	}
	
	public boolean catInsertService(Category cat) {
		
		return catRepo.Insert(cat);
		
	}
	
	public boolean catUpdateService(Category cat) {
		
		return catRepo.Update(cat);
		
	}
	
	public boolean catDeleteService(int varId) {
		
		return catRepo.Delete(varId);
		
	}
	

}

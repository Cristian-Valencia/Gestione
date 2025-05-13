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
		return catRepo.findAll();
	}
	
	public Category catDetailService(int varId) {
		
		return catRepo.findById(varId).orElse(null);
		
	}
	
//	public boolean catInsertService(Category cat) {
//		
//		return catRepo.Insert(cat);
//		
//	}
//	
//	public boolean catUpdateService(Category cat) {
//		
//		return catRepo.Update(cat);
//		
//	}
	
	public void catDeleteService(int varId) {
		
		catRepo.deleteById(varId);
		
	}
	

}

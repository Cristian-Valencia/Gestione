package sinapsys.gestione.services;

import java.util.List;
import java.util.Optional;

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
	
	public Category catInsertService(Category cat) {
		
		return catRepo.save(cat);
		
	}
	
	public Category catUpdateService(Category cat, Integer id) {
		
		Optional<Category> existingCategory = catRepo.findById(id);

        if (existingCategory.isPresent()) {
            Category categoryToUpdate = existingCategory.get();
            categoryToUpdate.setCategoryId(cat.getCategoryId());
            categoryToUpdate.setNameCategory(cat.getNameCategory());
            return catRepo.save(categoryToUpdate); 
        } else {
            return null; // Restituisci null se la categoria con l'ID specificato non esiste
        }
		
	}
	
	public void catDeleteService(int varId) {
		
		catRepo.deleteById(varId);
		
	}
	

}

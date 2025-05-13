package sinapsys.gestione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catServ;
	
	@GetMapping
	public List<Category> catList(){
		return catServ.catListService();	
	}
	
	
	@GetMapping("{varId}")
	public ResponseEntity catDetails(@PathVariable int varId) {
		
		Category cat = catServ.catDetailService(varId);
		
		if( cat == null )
			return ResponseEntity.notFound().build();
		else 
			return ResponseEntity.ok(cat);
		
	}
	
	
//	@PostMapping
//	public ResponseEntity catInsert(@RequestBody Category cat) {
//		
//		boolean insertResult = catServ.catInsertService(cat);
//		
//		if(insertResult)
//			return ResponseEntity.ok().build();
//		return ResponseEntity.badRequest().build();
//		
//		
//	}
//	
//	
//	@PutMapping("{varId}")
//	public ResponseEntity catUpdate(@PathVariable int varId, @RequestBody Category cat) {
//		
//		if(varId != 0) {
//			
//			cat.setId(varId);
//			
//			if(catServ.catUpdateService(cat))
//				return ResponseEntity.ok().build();
//			
//		}
//		
//		return ResponseEntity.badRequest().build();
//		
//	}
	
	@DeleteMapping("{varId}")
	public ResponseEntity<Void> catDelete(@PathVariable int varId) {
		
		try {
			
			catServ.catDeleteService(varId);
			return ResponseEntity.noContent().build();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
	
	
	

}

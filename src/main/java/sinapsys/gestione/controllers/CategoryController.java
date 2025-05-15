package sinapsys.gestione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	
	@PostMapping
	public ResponseEntity catInsert(@RequestBody Category cat) {
		
		try {
            // Logica di validazione (opzionale, ma consigliata)
            if (cat.getNameCategory() == null || cat.getNameCategory().trim().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Esempio di validazione
            }

            Category savedCategory = catServ.catInsertService(cat);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED); // Restituisci la categoria creata e lo status 201
        } catch (Exception e) {
            // Gestione dell'errore (log, eventuale custom exception, ecc.)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Gestisci l'errore in modo appropriato
        }
		
		
	}
	
	
	@PutMapping("{varId}")
	public ResponseEntity catUpdate(@PathVariable int varId, @RequestBody Category cat) {
		
        try {
            // Logica di validazione (opzionale, ma consigliata)
            if (cat.getNameCategory() == null || cat.getNameCategory().trim().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Category updatedCategory = catServ.catUpdateService(cat, varId);

            if (updatedCategory != null) {
                return new ResponseEntity<>(updatedCategory, HttpStatus.OK); // Restituisci la categoria aggiornata e lo status 200
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // La categoria con l'ID specificato non è stata trovata
            }
        } catch (Exception e) {
            // Gestione dell'errore
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}
	
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

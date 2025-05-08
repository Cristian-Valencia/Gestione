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

import sinapsys.gestione.models.Post;
import sinapsys.gestione.services.PostService;

@RestController
@RequestMapping("api/posts")
public class PostController {
	
	@Autowired
	private PostService posServ;
	
	
	@GetMapping
	public List<Post> postList(){
		
		return posServ.postListService();
	}
	
	
	@GetMapping("{varId}")
	public ResponseEntity postDetails(@PathVariable int varId) {
		
		Post resu = posServ.postDetailService(varId);
		
		if( resu == null)
			
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(resu);
		
		
	}
	
	
	@PostMapping
	public ResponseEntity postInsert(@RequestBody Post pos) {
		
		boolean insertResult = posServ.postInsertService(pos);
		
		if(insertResult)
			
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.unprocessableEntity().build();
			
	}
	
	
	@PutMapping("{varId}")
	public ResponseEntity postUpdate(@PathVariable int varId, @RequestBody Post pos) {
		
		if(varId != 0 ) {
			
			pos.setId(varId);
			
			if(posServ.posUpdateService(pos)){
				return ResponseEntity.ok().build();
			}
			
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@DeleteMapping("{varId}")
	public ResponseEntity postDelete(@PathVariable int varId) {
		
		if(posServ.posDeleteService(varId))
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();
		
	}
	
	
	
	

}

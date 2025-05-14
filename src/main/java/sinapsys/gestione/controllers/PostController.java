package sinapsys.gestione.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.models.CategoryDTO;
import sinapsys.gestione.models.Post;
import sinapsys.gestione.models.PostResponseDTO;
import sinapsys.gestione.repositories.PostRepository;
import sinapsys.gestione.services.PostService;

@RestController
@RequestMapping("api/posts")
public class PostController {
	
	@Autowired
	private PostService posServ;
	
	@Autowired
	private PostRepository postRepo;
	
	
	@GetMapping
	public List<Post> postList(){
		
		return posServ.postListService();
	}
	
	
	@GetMapping("{varId}")
	public ResponseEntity postDetails(@PathVariable int varId) {
		
		
		Optional<Post> postOptional = postRepo.findById(varId);
		if(postOptional.isPresent()) {
			
			Post post = postOptional.get();
			PostResponseDTO responseDTO = convertToDto(post);
			return ResponseEntity.ok(responseDTO);
			
		} else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	private PostResponseDTO convertToDto(Post post) {
		
		PostResponseDTO dto = new PostResponseDTO();
		dto.setId(post.getId());
		dto.setPostId(post.getPostId());
		dto.setTitle(post.getTitle());
		dto.setContent(post.getContent());
		dto.setAuthor(post.getAuthor());
		dto.setCreatedAt(post.getCreatedAt());
		dto.setCategories(post.getCategories().stream()
				.map(this::converttoCategoryDto)
				.collect(Collectors.toSet()));
		return dto;
		
		
	}
	
	
	private CategoryDTO converttoCategoryDto(Category category) {
		
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setCategoryId(category.getCategoryId());
		dto.setNameCategory(category.getNameCategory());
		return dto;
		
	}
	
	
	
	@PostMapping
	public ResponseEntity<Post> postInsert(@RequestBody Post post,
            @RequestParam(value = "categoryIds", required = false) List<Integer> categoryIds) {
		
		
		try {
			
			Post savedPost = posServ.postInsertService(post, categoryIds);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedPost.getId())
                    .toUri();
			
			return ResponseEntity.created(location).body(savedPost);
			
		} catch(RuntimeException e) {
			
			System.out.println("Errore durante l'inserimento del post: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null); 
			
		}
			
	}
	
	
	@PutMapping("{varId}")
	public ResponseEntity postUpdate(@PathVariable int varId, @RequestBody Post updatedPost) {
		
        Post post = posServ.posUpdateService(varId, updatedPost);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		
        
	}
	
	@DeleteMapping("{varId}")
	public ResponseEntity<Void> postDelete(@PathVariable int varId) {
		
        try {
            posServ.posDeleteService(varId);
            return ResponseEntity.noContent().build(); // 204 No Content, assumendo successo
        } catch (Exception e) {
            // Log dell'errore per debugging
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); // 400 Bad Request in caso di errore
        }
		
	}
	
	
	
	

}

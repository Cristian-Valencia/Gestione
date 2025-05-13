package sinapsys.gestione.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sinapsys.gestione.models.Category;
import sinapsys.gestione.models.Post;
import sinapsys.gestione.repositories.CategoryRepository;
import sinapsys.gestione.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	public List<Post> postListService(){
		
		return postRepo.findAll();
		
	}
	
	public Post postDetailService(int varId) {
		return postRepo.findById(varId).orElse(null);
	}
	
	@Transactional
	public Post postInsertService( Post pos, List<Integer> categoryIds ) {
		
        try {
            Post savedPost = postRepo.save(pos);

            if (categoryIds != null && !categoryIds.isEmpty()) {
                Set<Category> categories = new HashSet<>(catRepo.findAllById(categoryIds));
                savedPost.setCategories(categories);
                postRepo.save(savedPost); 
            }
            return savedPost;
        } catch (DataIntegrityViolationException e) {
        	
            throw new RuntimeException("Errore di integrità dati: " + e.getMessage(), e);
            
        } catch (EmptyResultDataAccessException e) {

            throw new RuntimeException("Errore: nessun risultato atteso " + e.getMessage(), e);
        } catch (JpaSystemException e) {

            throw new RuntimeException("Errore di sistema JPA: " + e.getMessage(), e);
            
        } catch (Exception e) {

            throw new RuntimeException("Errore durante l'inserimento del post: " + e.getMessage(), e);
            
        }
		
	}
	
	public Post posUpdateService( int id, Post updatePost ) {

		return postRepo.findById(id)
				.map(existingPost ->{
					
					existingPost.setPostId(updatePost.getPostId());
					existingPost.setTitle(updatePost.getTitle());
					existingPost.setContent(updatePost.getContent());
					existingPost.setAuthor(updatePost.getAuthor());
					existingPost.setCreatedAt(updatePost.getCreatedAt());
					
					existingPost.getCategories().clear();
					existingPost.getCategories().addAll(updatePost.getCategories());					
					
					return postRepo.save(updatePost);
					
				}).orElse(null);
				
		
	}
	
	public void posDeleteService( int varId ) {
		
		postRepo.deleteById(varId);
		
	}
	

}

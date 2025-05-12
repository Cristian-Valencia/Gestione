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
import sinapsys.gestione.repositories.CategoryRepo;
import sinapsys.gestione.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
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
            System.out.println("arrivato qui" + categoryIds);

            if (categoryIds != null && !categoryIds.isEmpty()) {
                Set<Category> categories = new HashSet<>(catRepo.findAllById(categoryIds));
                System.out.println(categories);
                savedPost.setCategories(categories);
                postRepo.save(savedPost); //Salvo le modifiche al post
            }
            return savedPost;
        } catch (DataIntegrityViolationException e) {
        	
        	System.out.println("Errore di integrità dati");
        	
            // Gestione specifica per violazioni di integrità (es., duplicato postId)
            throw new RuntimeException("Errore di integrità dati: " + e.getMessage(), e);
        } catch (EmptyResultDataAccessException e) {
            // Gestione specifica per nessun risultato atteso
        	System.out.println("Errore: nessun risultato atteso");
            throw new RuntimeException("Errore: nessun risultato atteso " + e.getMessage(), e);
        } catch (JpaSystemException e) {
            //Gestione errori JPA
        	System.out.println("Errore di sistema JPA");
            throw new RuntimeException("Errore di sistema JPA: " + e.getMessage(), e);
        } catch (Exception e) {
        	System.out.println("Errore durante linserimento del post");
            // Gestione di altri errori generici
            throw new RuntimeException("Errore durante l'inserimento del post: " + e.getMessage(), e);
        }
		
	}
	
//	public boolean posUpdateService( Post pos ) {
//		return postRepo.Update(pos);
//	}
	
	public void posDeleteService( int varId ) {
		
		postRepo.deleteById(varId);
		
	}
	

}

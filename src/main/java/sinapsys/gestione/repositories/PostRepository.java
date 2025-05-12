package sinapsys.gestione.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import sinapsys.gestione.models.Category;
import sinapsys.gestione.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
//
//	@Autowired
//	PostRepo repo;
//	
//	@Autowired 
//	private CategoryRepo catRepo;
//	
//
//	public List<Post> getAll() {
//
//		return repo.findAll();
//
//	}
//	
//
//	public Post getById(int id) {
//
//		return repo.findById(id).orElse(null);
//		
//	}
//	
//
//	@Transactional
//	public Post Insert(Post obj, List<Integer> categoryIds) {

//		try { 
//			repo.save(obj);
//			return true;
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			return false;
//			
//		}
//		
//		try {
//			return repo.save(obj);
//		} catch(DataIntegrityViolationException e) {
//			
//			throw new RuntimeException("Errore di integrità dati: " + e.getMessage(), e);
//			
//		} catch(EmptyResultDataAccessException e) {
//			
//			throw new RuntimeException("Errore: nessun risultato atteso" + e.getMessage(), e);
//	
//		} catch( Exception e ) {
//			throw new RuntimeException("Errore durante l'inserimento del post: " + e.getMessage(), e);
//		}
//		
//		
//		try {
//			
//			Post savedPost = repo.save(obj);
//			
//			if(categoryIds != null && !categoryIds.isEmpty()) {
//				
//				Set<Category> categories = new HashSet<>(catRepo.findAllById(categoryIds));
//				
//			}
//			
//		}
//
//	}
//
//
//	public boolean Update(Post obj) {
//		
//		try {
//			repo.save(obj);
//			return true;
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			return false;
//			
//		}
//		
//	}
//
//
//	public boolean Delete(int id) {
//
//
//		
//		try {
//			repo.deleteById(id);
//			return true;
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			return false;
//			
//		}
//		
//		
//
//	}



	
	

}

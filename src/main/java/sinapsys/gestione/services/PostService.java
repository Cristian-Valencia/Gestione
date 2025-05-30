package sinapsys.gestione.services;

import java.util.ArrayList;
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
import sinapsys.gestione.models.CategoryDTO;
import sinapsys.gestione.models.Post;
import sinapsys.gestione.models.PostResponseDTO;
import sinapsys.gestione.repositories.CategoryRepository;
import sinapsys.gestione.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	public List<PostResponseDTO> postListService(){
		
		List<Post> posts = postRepo.findAll();
		
		List<PostResponseDTO> postDTOs = new ArrayList<>();
		
        for (Post post : posts) {
        	PostResponseDTO postDTO = new PostResponseDTO();
            postDTO.setId(post.getId());
            postDTO.setPostId(post.getPostId());
            postDTO.setTitle(post.getTitle());
            postDTO.setContent(post.getContent());
            postDTO.setAuthor(post.getAuthor());
            postDTO.setCreatedAt(post.getCreatedAt());

            Set<CategoryDTO> categoryDTOs = new HashSet<>();
            for (Category category : post.getCategories()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setCategoryId(category.getCategoryId());
                categoryDTO.setNameCategory(category.getNameCategory());
                categoryDTOs.add(categoryDTO);
            }
            postDTO.setCategories(categoryDTOs);
            postDTOs.add(postDTO);
        }

		return postDTOs;
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
	
	@Transactional
	public Post posUpdateService( int id, Post updatePost, List<Integer> categoriesIds ) {

		return postRepo.findById(id)
				.map(existingPost ->{
					
					

					existingPost.setPostId(updatePost.getPostId());
					existingPost.setTitle(updatePost.getTitle());
					existingPost.setContent(updatePost.getContent());
					existingPost.setAuthor(updatePost.getAuthor());
					existingPost.setCreatedAt(updatePost.getCreatedAt());
					
					
					
					if (categoriesIds != null && !categoriesIds.isEmpty()) {
						Set<Category> categories = new HashSet<>(catRepo.findAllById(categoriesIds));		                
						existingPost.setCategories(categories);
		            }
										
					return postRepo.save(existingPost);
					
				}).orElse(null);
				
		
	}
	

	
	
	public void posDeleteService( int varId ) {
		
		postRepo.deleteById(varId);
		
	}
	

}

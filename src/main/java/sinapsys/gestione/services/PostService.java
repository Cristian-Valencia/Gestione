package sinapsys.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sinapsys.gestione.models.Post;
import sinapsys.gestione.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public List<Post> postListService(){
		
		return postRepo.getAll();
		
	}
	
	public Post postDetailService(int varId) {
		return postRepo.getById(varId);
	}
	
	public boolean postInsertService( Post pos ) {
		return postRepo.Insert(pos);
	}
	
	public boolean posUpdateService( Post pos ) {
		return postRepo.Update(pos);
	}
	
	public boolean posDeleteService( int varId ) {
		
		return postRepo.Delete(varId);
		
	}
	

}

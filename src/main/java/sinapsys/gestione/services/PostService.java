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
	

}

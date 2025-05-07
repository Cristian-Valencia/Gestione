package sinapsys.gestione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}

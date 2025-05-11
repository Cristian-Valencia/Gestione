package sinapsys.gestione.repositories;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Post;

@Repository
public class PostRepository implements IRepositoryRead<Post>, IRepositoryWrite<Post> {
	

	@Autowired
	PostRepo repo;
	
	
	
	@Override
	public boolean Insert(Post obj) {

		try {
			repo.save(obj);
			return true;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
			
		}

	}

	@Override
	public boolean Update(Post obj) {
		
		try {
			repo.save(obj);
			return true;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}

	@Override
	public boolean Delete(int id) {


		
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
			
		}
		
		

	}

	@Override
	public Post getById(int id) {

		return repo.findById(id).orElse(null);
		
	}

	@Override
	public List<Post> getAll() {

		return repo.findAll();

	}
	

	
	

}

package sinapsys.gestione.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	

}

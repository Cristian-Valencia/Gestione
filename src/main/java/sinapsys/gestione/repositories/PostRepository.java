package sinapsys.gestione.repositories;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import sinapsys.gestione.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//	@Query("SELECT p FROM Post p JOIN FETCH p.categories")
//	List<Post> findAllWithCategories();


}



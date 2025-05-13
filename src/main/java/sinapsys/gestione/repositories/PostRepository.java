package sinapsys.gestione.repositories;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	

}



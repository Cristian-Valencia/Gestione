package sinapsys.gestione.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.models.Post;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Optional<Category> findByCategoryId(String categoryId);
	

	
}

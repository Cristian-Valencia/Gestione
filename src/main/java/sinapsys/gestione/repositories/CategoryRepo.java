package sinapsys.gestione.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	Optional<Category> findByCategoryId(String categoryId);

}

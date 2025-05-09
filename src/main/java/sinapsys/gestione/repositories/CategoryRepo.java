package sinapsys.gestione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	

}

package sinapsys.gestione.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catServ;
	
	@GetMapping
	public List<Category> catList(){
		return catServ.catListService();	
	}

}

package sinapsys.gestione.models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;



@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryId;
	private String nameCategory;	
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference("posts")
	@JsonIgnore
	private Set<Post> posts = new HashSet<>();
	
	public Category() {
		
	}
	
	
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryId=" + categoryId + ", nameCategory=" + nameCategory + ", posts="
				  + "]";
	}

	
	
	
}

package sinapsys.gestione.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryId;
	private String nameCategory;	
//	private ArrayList<Post> posts;
	
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
//	public ArrayList<Post> getPosts() {
//		return posts;
//	}
//	public void setPosts(ArrayList<Post> posts) {
//		this.posts = posts;
//	}
//
//	@Override
//	public String toString() {
//		return "Category [id=" + id + " + categoryId=" + categoryId +  ", name=" + name + ", posts=" + posts + "]";
//	}
//	
	
}

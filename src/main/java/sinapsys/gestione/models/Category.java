package sinapsys.gestione.models;

import java.util.ArrayList;

public class Category {
	
	
	private int id;
	private String name;	
	private ArrayList<Post> posts;
	
	public Category() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
	
}

package sinapsys.gestione.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
@JsonIgnoreProperties("categories")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String postId;
	private String title;
	private String content;
	private String author;
	private Date createdAt;	
	
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "post_category",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )  
    @JsonManagedReference()
    private Set<Category> categories = new HashSet<>();
	
	
	public Post() {
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Set<Category> getCategories() {
		return categories;
	}





	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}





	@Override
	public String toString() {
		return "Post [id=" + id + ", postId=" + postId + ", title=" + title + ", content=" + content + ", author="
				+ author + ", createdAt=" + createdAt + ", categories="  + "]";
	}


	
	

	
	
	

}

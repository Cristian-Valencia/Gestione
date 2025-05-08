package sinapsys.gestione.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;
import sinapsys.gestione.models.Post;

@Repository
public class PostRepository implements IRepositoryRead<Post>, IRepositoryWrite<Post> {
	
	
	private final DataSource ds;
	
	public PostRepository( DataSource dataSource ) {
		
		this.ds = dataSource;
		
	}
	
	
	
	@Override
	public boolean Insert(Post obj) {
		boolean result = false;
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "INSERT into post (postId, title, content, author, createdAt) VALUES"
					+ "( ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getPostId());
			ps.setString(2, obj.getTitle());
			ps.setString(3, obj.getContent());
			ps.setString(4, obj.getAuthor());
			ps.setDate(5, obj.getCreatedAt());
			
			int affRows = ps.executeUpdate();
			
			if(affRows > 0 )
				return true;
			
			conn.close();
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return result;
	}

	@Override
	public boolean Update(Post obj) {

		boolean result = false;
		
		
		try {
			
			Connection conn = ds.getConnection();
			
			int id = obj.getId();
			
			Post pos = this.getById(id);
			
			if( pos != null ) {
				
				pos.setPostId(obj.getPostId() == null ? obj.getPostId() : obj.getPostId());
				pos.setTitle(obj.getTitle() == null ? obj.getTitle() : obj.getTitle());
				pos.setContent(obj.getContent() == null ? obj.getContent() : obj.getContent());
				pos.setAuthor(obj.getAuthor() == null ? obj.getAuthor() : obj.getAuthor());
				pos.setCreatedAt(obj.getCreatedAt() == null ? obj.getCreatedAt() : obj.getCreatedAt());
				
				String query = "UPDATE post SET "
						+ "postId = ?, "
						+ "title = ?, "
						+ "content = ?, "
						+ "author = ? "
						+ "WHERE id = ? ";
				
			
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, pos.getPostId());
				ps.setString(2, pos.getTitle());
				ps.setString(3, pos.getContent());
				ps.setString(4, pos.getAuthor());
				ps.setInt(5, pos.getId());
				
//				System.out.println(query);
//				
//				System.out.println(ps);
				
				int affRows = ps.executeUpdate();
				
				if(affRows > 0)
					result = true;
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return result;
		
	}

	@Override
	public boolean Delete(int id) {
		boolean result = false;
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "DELETE FROM post WHERE id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int affRows = ps.executeUpdate();
			
			if(affRows > 0)
				return true;
			
			conn.close();
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return result;
	}

	@Override
	public Post getById(int id) {


		Post pos = null;
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "SELECT id, postId, title, content, author, createdAt FROM Post WHERE id = ? ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				pos = new Post();
				
				pos.setId(rs.getInt("id"));
				pos.setPostId(rs.getString("postId"));
				pos.setTitle(rs.getString("title"));
				pos.setContent(rs.getString("content"));
				pos.setAuthor(rs.getString("author"));
				pos.setCreatedAt(rs.getDate("createdAt"));
				
			}
			
			conn.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return pos;
		
	}

	@Override
	public List<Post> getAll() {

		List<Post> list = new ArrayList<Post>();
		List<Category> listCategory = new ArrayList<Category>();
		
		
		try {
			
			Connection conn = ds.getConnection();
			
			int id = 0;
			
			String query = "SELECT id, postId, title, content, author, createdAt FROM post";
			String queryCategory = "Select c.id AS categoryId, c.categoryId AS codeCategory, c.nameCategory AS nameCategory FROM post p JOIN post_category pc ON p.id = pc.postId JOIN category c ON pc.categoryId = c.id WHERE p.id = " + id;
			
			
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement psCategory = conn.prepareStatement(queryCategory);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Post pos = new Post();
				pos.setId(rs.getInt("id"));
				pos.setPostId(rs.getString("postId"));
				pos.setTitle(rs.getString("title"));
				pos.setContent(rs.getString("content"));
				pos.setAuthor(rs.getString("author"));
				pos.setCreatedAt(rs.getDate("createdAt"));
				
//				System.out.println("risposta prima query " + rs);
				
//					while(rs.next()) {
						
//						id = rs.getInt("id");
//						
//						ResultSet rsCategory = psCategory.executeQuery();
//						
//						System.out.println("risposta seconda query " + rsCategory);
//						
//						Category cat = new Category();
//						cat.setId(rsCategory.getInt("categoryId"));
//						cat.setCategoryId(rsCategory.getString("codeCategory"));
//						cat.setName(rsCategory.getString("nameCategory"));
//						
//					}

				
//				pos.setCategories(null);
					
				list.add(pos);
				
				
				
			}
			
			conn.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

		return list;
	}
	

	
	

}

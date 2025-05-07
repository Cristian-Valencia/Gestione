package sinapsys.gestione.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Post;

@Repository
public class PostRepository implements IRepositoryRead<Post>, IRepositoryWrite<Post> {
	
	
	private final DataSource ds;
	
	public PostRepository( DataSource dataSource ) {
		
		this.ds = dataSource;
		
	}
	
	
	
	@Override
	public boolean Insert(Post obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Post obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Post getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAll() {

		List<Post> list = new ArrayList<Post>();
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "SELECT id, postId, title, content, author, createdAt FROM post";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Post pos = new Post();
				pos.setId(rs.getInt("id"));
				pos.setPostId(rs.getString("postId"));
				pos.setTitle(rs.getString("title"));
				pos.setContent(rs.getString("content"));
				pos.setAuthor(rs.getString("author"));
				pos.setCreatedAt(rs.getDate("createdAt"));
			
				list.add(pos);
			}
			
			conn.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

		return list;
	}
	

	
	

}

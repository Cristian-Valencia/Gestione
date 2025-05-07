package sinapsys.gestione.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;



@Repository
public class CategoryRepository implements IRepositoryRead<Category>, IRepositoryWrite<Category> {
	
	private final DataSource ds;
	
	public CategoryRepository( DataSource dataSource ) {
		this.ds = dataSource;
	}
	
	

	@Override
	public boolean Insert(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		
		List<Category> list = new ArrayList<Category>();
		
		try {
			
			Connection conn = ds.getConnection();
			
			String query = "SELECT id, categoryId, nameCategory FROM category";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Category cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setCategoryId(rs.getString("categoryId"));
				cat.setName(rs.getString("nameCategory"));
			
				list.add(cat);
			}
			
			conn.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

		return list;
	}
	
	
	
	

}

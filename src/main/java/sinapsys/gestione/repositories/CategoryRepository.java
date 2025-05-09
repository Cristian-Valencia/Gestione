package sinapsys.gestione.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sinapsys.gestione.models.Category;



@Repository
public class CategoryRepository implements IRepositoryRead<Category>, IRepositoryWrite<Category> {
	
	private final DataSource ds;
	
	@Autowired CategoryRepo repo;
	
	public CategoryRepository( DataSource dataSource ) {
		this.ds = dataSource;
	}
	
	
	
	@Override
	public List<Category> getAll() {
		

		return repo.findAll();
		
//		try {
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "SELECT id, categoryId, nameCategory FROM category";
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				
//				Category cat = new Category();
//				cat.setId(rs.getInt("id"));
//				cat.setCategoryId(rs.getString("categoryId"));
//				cat.setNameCategory(rs.getString("nameCategory"));
//			
//				list.add(cat);
//			}
//			
//			conn.close();
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
//
//		return list;
	}
	
	
	@Override
	public Category getById(int id) {
		
		return repo.findById(id).orElse(null);

//		Category cat = null;
//		
//		try {
//			
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "SELECT id, categoryId, nameCategory FROM category WHERE id = ? ";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			
//			
//			while(rs.next()) {
//				
//				cat = new Category();
//				cat.setId(rs.getInt("id"));
//				cat.setCategoryId(rs.getString("categoryId"));
//				cat.setNameCategory(rs.getString("nameCategory"));
//				
//				
//			}
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
//
//		return cat;
	}

	
	
	

	@Override
	public boolean Insert(Category obj) {
		

			repo.save(obj);
			return true;


//		boolean result = false;
//		
//		try {
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "INSERT INTO category (categoryId, nameCategory) VALUES"
//					+ "(?, ?)";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, obj.getCategoryId());
//			ps.setString(2, obj.getNameCategory());
//			
//			int affRows = ps.executeUpdate();
//			
//			if(affRows > 0)
//				return true;
//			
//			conn.close(); 
//			
//			
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
//		
//		
//		return false;
	}

	@Override
	public boolean Update(Category obj) {
		
		repo.save(obj);
		
		return false;

//		boolean result = false;
//		
//		
//		try {
//			
//			Connection conn = ds.getConnection();
//			
//			int id = obj.getId();
//			
//			Category cat = this.getById(id);
//			
//			if( cat != null ) {
//				
//				System.out.println(obj);
//				
//				cat.setCategoryId(obj.getCategoryId() == null ? obj.getCategoryId() : obj.getCategoryId());
//				cat.setNameCategory(obj.getNameCategory() == null ? obj.getNameCategory() : obj.getNameCategory());
//				
//				
//			
//				String query = "UPDATE category SET "
//						+"categoryId = ?, "
//						+"nameCategory = ? "
//						+"WHERE id = ?";
//				
//			
//				
//				PreparedStatement ps = conn.prepareStatement(query);
//				ps.setString(1, cat.getCategoryId());
//				ps.setString(2, cat.getNameCategory());
//				ps.setInt(3, cat.getId());
//				
//				System.out.println(ps);
//				
//				
//				int affRows = ps.executeUpdate();
//				
//				if(affRows > 0)
//					result = true;
//				
//			}
//			
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
//		
//		return result;
	}

	@Override
	public boolean Delete(int id) {

		boolean result = false;
		
		try {
			
			
			repo.deleteById(id);
			
			
			result = true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return result;
		
//		boolean result = false;
//
//		try {
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "DELETE FROM category WHERE id = ?";
//					
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, id);
//			
//			int affRows = ps.executeUpdate();
//			
//			if ( affRows > 0 )
//				return true;
//			
//			conn.close();
//			
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
//		
//		return result;
	}



	
	
	
	

}

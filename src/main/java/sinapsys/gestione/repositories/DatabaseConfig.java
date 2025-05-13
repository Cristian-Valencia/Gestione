package sinapsys.gestione.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;



@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() throws SQLException {
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setUser("root");
		ds.setPassword("toor");
		ds.setDatabaseName("progetto_categoria_post");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
		
		return ds;
		
	}
	
	@Bean
	public Connection connection(DataSource dataSource) throws SQLException {
		return dataSource.getConnection();
	}
	
	
}
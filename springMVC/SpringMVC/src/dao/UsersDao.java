package dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import classes.User;

@Component
public class UsersDao {
	
	private DataSource dataSource;
	private JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		template=new JdbcTemplate(dataSource);
	}
	
	public void create(User user) {
		String SQL="insert into users(username,password,authority,enabled) values(?,?,?,?)";
		String SQL2="insert into authorities(username,authority) values(?,?)";

		template.update(SQL,new Object[] {user.getUsername(),user.getPassword(),user.getAuthority(),user.isEnabled()});
		template.update(SQL2,new Object[] {user.getUsername(),user.getAuthority()});
	}
	
}

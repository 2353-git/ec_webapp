package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.UserBean;

public class UserDAO extends DAO{
	public UserBean search(String name, String password) throws Exception{
		UserBean user = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from users where name=? and password=?");
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return user;
	}



}

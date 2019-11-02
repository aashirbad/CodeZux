package com.codezux.DAO;

import com.codezux.Bean.UserRegistrationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistrationDAO {
	public int registrationUser(UserRegistrationBean userBean) {

		Connection con = null;
		con = DBConnection.getConnect();
		try {

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO my_prj.user_profile " + "(name,email_id) VALUES (?,?)");
			ps.setString(1, userBean.getUname());
			ps.setString(2, userBean.getUemail());
			setPassword(userBean);
			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}
	
	
	/*
	 * 			Update pass
	 */

	private void setPassword(UserRegistrationBean userBean) {
		

		Connection con = null;
		con = DBConnection.getConnect();
		try {

			PreparedStatement ps = con.prepareStatement("INSERT INTO my_prj.user_authenticate " + "(password) VALUES (?)");
			ps.setString(1, userBean.getUpass());
			ps.execute();
			}
		catch (Exception e) {
					e.printStackTrace();
		}
	}
		
		/*
	public void update(UserRegistrationBean userBean) {

		Connection con = null;
		con = DBConnection.getConnect();
		try {

			PreparedStatement ps = con.prepareStatement("INSERT INTO prj1.userAuth " + "(password) VALUES (?)",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, userBean.getUpass());
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} 
		}
		
		
	*/
	}

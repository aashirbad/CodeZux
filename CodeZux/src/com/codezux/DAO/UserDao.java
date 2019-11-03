package com.codezux.DAO;

import com.codezux.Bean.UserProfilePojo;
import com.codezux.Bean.UserRegistrationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	
	/*
	 *   	user Registration
	 */
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
	 * 			Update pass In user_authenticate table
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
	 * Log In Authentication
	 */
	public boolean authenticateUser(int uid, String upass) {
		
		Connection con = null;
		con = DBConnection.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement("select uid,password from my_prj.user_authenticate where uid = (?) and password =(?) ");
			ps.setInt(1, uid);
			ps.setString(2, upass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

/*
 * 
 * 
 * 		Some issue
 * java.lang.NullPointerException
	at com.codezux.DAO.UserDao.getUserProfileDetailsById(UserDao.java:122)
	at com.codezux.Service.UserService.getUserProfileDetailById(UserService.java:35)
 * 
 */
	
	// give user Details
	public UserProfilePojo getUserProfileDetailsById(int uid) {
		
		Connection con = null;
		PreparedStatement ps = null;
		UserProfilePojo userProf = null;
		try {
			
			con = DBConnection.getConnect();
			ps = con.prepareStatement("select user_profile.name,user_authenticate.uid from my_prj.user_profile,my_prj.user_authenticate  where user_authenticate.uid = ? ");
			ps.setInt(1, uid);
		
			ResultSet rs = ps.executeQuery();
			if( rs .next())
			{
			userProf.setuId(uid);
				userProf.setName(rs.getString("user_profile.name"));
				userProf.setCity(rs.getString("city"));
				userProf.setCollege(rs.getString("college"));
				//userProf.setDob(rs.getDate("dob"));
				userProf.setEmail(rs.getString("email"));
				userProf.setMobile(rs.getInt("mobile_number"));
				userProf.setPin(rs.getInt("pin"));
				userProf.setState(rs.getString("state"));
	
				
				System.out.println(uid + "\t " + rs.getString("name") + " \t" );
			}
			
		} catch (NullPointerException e) {
			
			System.out.println("Please fill reg form");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			}
			 catch (SQLException e) {
			
				e.printStackTrace();}
	}



		
		return userProf;
	}
		
}

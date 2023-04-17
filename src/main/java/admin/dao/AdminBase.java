package admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.bean.Admin;

public class AdminBase {
	private String jdbcUrl = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_ADMIN = "INSERT INTO admin" + "(nom, email, telephone, password) VALUES" + "(?, ?, ?, ?);";
	private static final String SELECT_ALL = "SELECT * FROM admin";
	private static final String DELETE_ADMIN = "DELETE from admin where id = ?";
	
	// get connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection; 
	}
	
	public void insertAdmin(Admin admin) throws SQLException{
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN)){
			preparedStatement.setString(1, admin.getNom());
			preparedStatement.setString(2, admin.getEmail());
			preparedStatement.setString(3, admin.getTelephone());
			preparedStatement.setString(4, admin.getPassword());
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// selected all
	public List<Admin> selectallAdmin(){
		List<Admin> admins = new ArrayList<>();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String password = rs.getString("password");
				admins.add(new Admin(id,nom, email, telephone, password));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admins;
		
	}
	
	//detete
	
	public boolean deleteAdmin(int id) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}

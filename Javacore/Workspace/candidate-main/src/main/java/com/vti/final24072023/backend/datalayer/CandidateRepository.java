package com.vti.final24072023.backend.datalayer;

import java.sql.*;

import com.vti.final24072023.entity.Candidate;
import com.vti.final24072023.entity.ExperienceCandidate;
import com.vti.final24072023.entity.FresherCandidate;
import com.vti.final24072023.entity.GraduationRank;
import com.vti.final24072023.entity.Role;
import com.vti.final24072023.utils.JDBCUtils;

public class CandidateRepository implements ICandidateRepository {

	private JDBCUtils jdbcUtils;

	public CandidateRepository() {
		jdbcUtils = new JDBCUtils();
	}
	
	// dki cho 	ExperienceCandidate
	public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws ClassNotFoundException, SQLException {
		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.getConnection();

			// Step 2: Create a statement obiect
			String sql = "INSERT INTO `candidate` (`fisrtname`, `lastname`, `phone`, `email`, `password`, `exp_in_year`, `pro_skill`, `role`) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, 'EXPERIENCECANDIDATE');";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, phone);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.setInt(6, expInYear);
			statement.setString(7, proSkill);
			
//			ResultSet rSet = statement.executeQuery(); // cau query   select  ko thay đổi dữ liệu trong DB

			// Step 3: Execute SQL query
			int c = statement.executeUpdate();// insert delete update: thay đổi dữ liệu trong DB
			if (c > 0) {
				return true;
			} else {
				return false;
			}

		} finally {
			jdbcUtils.disconnect();
		}
	}

	// dki cho FresherCandidate
	public boolean registerF(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank, String password) throws SQLException, ClassNotFoundException {
		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.getConnection();

			// Step 2: Create a statement obiect
			String sql = "INSERT INTO candidate (fisrtname, lastname, phone, email, `password`,  GraduationRank, `role`)" +
					" VALUES (?, ?, ?, ?, ?, ?, 'FRESHERCANDIDATE');";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, phone);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.setString(6, String.valueOf(graduationRank)); // từ enum --> string

			// Step 3: Execute SQL query
			int c = statement.executeUpdate();
			if (c > 0) {
				return true;
			} else {
				return false;
			}

		} finally {
			jdbcUtils.disconnect();
		}
	}

	public Candidate login(String email, String password) throws SQLException, ClassNotFoundException {
		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.getConnection();

			// Step 2: Create a statement obiect
			String sql = "select * from candidate where email = ? and `password` = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);

			// Step 3: Execute SQL query
			ResultSet resultSet = statement.executeQuery();

			// Step 4: Handling Result Set
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String phone = resultSet.getString(4);

				String role = resultSet.getString(10);// string
				// chuyen tu string về enum
				Role rol = Role.valueOf(role);

				if (Role.EXPERIENCECANDIDATE.equals(rol)) {
					int expInYear = resultSet.getInt(7);
					String proSkill = resultSet.getString(8);

					Candidate e = new ExperienceCandidate(id, firstName, lastName, phone, email, password, rol,
							expInYear, proSkill);
					return e;
				} else {
					GraduationRank graduationRank = null;
					// chuyển rank từ String >>> enum
					String g = resultSet.getString(9);
					graduationRank = GraduationRank.valueOf(g);
					
					Candidate f = new FresherCandidate(id, firstName, lastName, phone, email, password, rol,
							graduationRank);
					return f;
				}
			} else {
				return null;
			}
		} finally {
			jdbcUtils.disconnect();
		}

	}

	// kiem tra trước khi insert dữ liệu xem email dã tồn tại chưa
	public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.getConnection();

			// Step 2: Create a statement obiect
			String sql = "SELECT * FROM candidate WHERE Email = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);

			// Step 3: Execute SQL query
			ResultSet resultSet = statement.executeQuery();

			// Step 4: Handling Result Set
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} finally {
			jdbcUtils.disconnect();
		}
	}
	//email : abc
	//1,  123
	//2.  456

}

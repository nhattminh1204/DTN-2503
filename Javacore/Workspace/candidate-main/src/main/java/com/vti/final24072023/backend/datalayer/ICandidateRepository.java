package com.vti.final24072023.backend.datalayer;

import java.sql.SQLException;

import com.vti.final24072023.entity.Candidate;
import com.vti.final24072023.entity.GraduationRank;

public interface ICandidateRepository {

	boolean registerE(String firstName, String lastName, String phone, String email, int expInYear, String proSkill,
			String password) throws ClassNotFoundException, SQLException;

	boolean registerF(String firstName, String lastName, String phone, String email, GraduationRank graduationRank,
			String password) throws SQLException, ClassNotFoundException;

	Candidate login(String email, String password) throws SQLException, ClassNotFoundException;

	boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException;

}

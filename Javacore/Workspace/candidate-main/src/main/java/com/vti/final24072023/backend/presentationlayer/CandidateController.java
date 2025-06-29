package com.vti.final24072023.backend.presentationlayer;

import java.sql.SQLException;

import com.vti.final24072023.backend.businesslayer.CandidateService;
import com.vti.final24072023.backend.businesslayer.ICandidateService;
import com.vti.final24072023.entity.Candidate;
import com.vti.final24072023.entity.GraduationRank;

public class CandidateController {

	private ICandidateService candidateService;

	public CandidateController() {
		candidateService = new CandidateService();
	}


	public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws ClassNotFoundException, SQLException {

		return candidateService.registerE(firstName, lastName, phone, email, expInYear, proSkill, password);
	}

	public boolean registerF(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank, String password) throws SQLException, ClassNotFoundException {

		return candidateService.registerF(firstName, lastName, phone, email, graduationRank, password);
	}

	public Candidate login(String email, String password) throws SQLException, ClassNotFoundException {

		return candidateService.login(email, password);
	}

	public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
		return candidateService.isUserExistsByEmail(email);

	}

}

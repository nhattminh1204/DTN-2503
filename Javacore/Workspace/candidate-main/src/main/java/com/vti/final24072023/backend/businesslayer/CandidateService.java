package com.vti.final24072023.backend.businesslayer;

import java.sql.SQLException;

import com.vti.final24072023.backend.datalayer.CandidateRepository;
import com.vti.final24072023.backend.datalayer.ICandidateRepository;
import com.vti.final24072023.entity.Candidate;
import com.vti.final24072023.entity.GraduationRank;

public class CandidateService implements ICandidateService {

	private ICandidateRepository candidateRepository;

	public CandidateService() {
		candidateRepository = new CandidateRepository();
	}

	public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws ClassNotFoundException, SQLException {
		return candidateRepository.registerE(firstName, lastName, phone, email, expInYear, proSkill, password);
	}

	public boolean registerF(String firstName, String lastName, String phone, String email,
			GraduationRank graduationRank, String password) throws SQLException, ClassNotFoundException {
		return candidateRepository.registerF(firstName, lastName, phone, email, graduationRank, password);
	}

	public Candidate login(String email, String password) throws SQLException, ClassNotFoundException {
		return candidateRepository.login(email, password);
	}

	public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
		return candidateRepository.isUserExistsByEmail(email);
	}

}

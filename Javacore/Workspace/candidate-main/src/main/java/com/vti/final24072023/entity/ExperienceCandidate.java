package com.vti.final24072023.entity;

public class ExperienceCandidate extends Candidate {

	private int expInYear;
	private String proSkill;

	public ExperienceCandidate(int id, String firstName, String lastName, String phone, String email, String password,
			Role role, int expInYear, String proSkill) {
		super(id, firstName, lastName, phone, email, password, role);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}

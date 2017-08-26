package com.teste.jobvacancy.models;

public class JobApplication {
	private JobVacancy vacancy;
	private Candidate candidate;
	
	public JobApplication(JobVacancy vacancy, Candidate candidate) {
		this.vacancy = vacancy;
		this.candidate = candidate;
	}

	public JobVacancy getVacancy() {
		return vacancy;
	}

	public Candidate getCandidate() {
		return candidate;
	}

}

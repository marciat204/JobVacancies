package com.teste.jobvacancy.models;

import java.util.ArrayList;

public class JobVacancy {
	private int id;
	private String company, name, description;
	private ArrayList<Candidate> candidates;
	
	
	public JobVacancy() {
		// TODO Auto-generated constructor stub
	}
	
	public JobVacancy(int id, String company, String name, String description) {		
		this.id = id;
		this.company = company;
		this.name = name;
		this.description = description;
		candidates = new ArrayList<Candidate>();		
	}

	public int getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}

	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}
}

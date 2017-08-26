package com.teste.jobvacancy.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.teste.jobvacancy.models.Candidate;
import com.teste.jobvacancy.models.JobVacancy;

@Service("VacanciesManage")
public class VacanciesManage {
	
	public VacanciesManage() {
		preencher();
	}

	private ArrayList<JobVacancy> vacancies = new ArrayList<JobVacancy>();
	static {
			
	}

	public ArrayList<JobVacancy> getVacancies() {
		return vacancies;
	}
	
	public void addVacancy(JobVacancy vacancy) {
		vacancies.add(vacancy);
	}
	
	public void applyVacancy(int vacancyID, Candidate candidate) {
		JobVacancy vacancy = vacancies.stream().filter( j -> j.getId() == vacancyID).findFirst().get();
		if (vacancy != null) {
			vacancy.addCandidate(candidate);
		}		
	}
	
	private void preencher() {
		vacancies.add(new JobVacancy(1, "Tese", "email@teste.com", "999999999"));
		vacancies.add(new JobVacancy(3, "Tese2", "email@teste.com", "999999999"));
		vacancies.add(new JobVacancy(2, "Tese3", "email@teste.com", "999999999"));
		vacancies.add(new JobVacancy(4, "Tese4", "email@teste.com", "999999999"));
	}
}

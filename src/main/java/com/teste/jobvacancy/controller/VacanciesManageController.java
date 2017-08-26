package com.teste.jobvacancy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.jobvacancy.models.Candidate;
import com.teste.jobvacancy.models.JobVacancy;
import com.teste.jobvacancy.service.VacanciesManage;

@RestController
public class VacanciesManageController {

	@Autowired
	VacanciesManage vacanciesManage;

	@RequestMapping(value = "/vacancies", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<JobVacancy>> listAllVacancies() {		 
		ArrayList<JobVacancy> vacancies = vacanciesManage.getVacancies();
		if (vacancies.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ArrayList<JobVacancy>>(vacancies, HttpStatus.OK);
	}

	@RequestMapping(value = "/vacancies", method = RequestMethod.POST)
	public ResponseEntity<?> createVacancy(@RequestBody JobVacancy vacancy) {
		if (vacancy == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		vacanciesManage.addVacancy(vacancy);
		return new ResponseEntity<JobVacancy>(vacancy, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/apply/{vacancyId}", method = RequestMethod.POST)
	public ResponseEntity<?> applyVacancy(@PathVariable("vacancyId") int vacancyId, @RequestBody  Candidate candidate) {
		if (candidate == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		vacanciesManage.applyVacancy(vacancyId, candidate);
		return new ResponseEntity(HttpStatus.CREATED);
	}

}

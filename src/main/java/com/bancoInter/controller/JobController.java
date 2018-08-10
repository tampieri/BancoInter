package com.bancoInter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bancoInter.entity.JobEntity;
import com.bancoInter.repository.jobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private jobRepository repository;
	
	@GetMapping
	public Iterable<JobEntity> list(){
		return repository.findAll();
	}
	
	@ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JobEntity findById(@PathVariable("id") Long idJob) {
        return repository.findOne(idJob);
    }
	
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") Long idJob) {
        return ResponseEntity.status(HttpStatus.OK).body("Job update with sucess.");
    }
	
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") Long idJob) {
        repository.deleteById(idJob);
        return ResponseEntity.status(HttpStatus.OK).body("Job delete with sucess.");
    }
	
	
	
	
	
	

}

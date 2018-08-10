package com.bancoInter.controller;

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

import com.bancoInter.entity.TaskEntity;
import com.bancoInter.repository.TaskRepository;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@GetMapping
	public Iterable<TaskEntity> list(){
		return repository.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TaskEntity findById(@PathVariable("id") Long idTask) {
		return repository.findOne(idTask);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable("id") Long idTask) {
		return ResponseEntity.status(HttpStatus.OK).body("Task update with sucess.");
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long idTask) {
		repository.deleteById(idTask);
		return ResponseEntity.status(HttpStatus.OK).body("Task delete with sucess.");
	}
}

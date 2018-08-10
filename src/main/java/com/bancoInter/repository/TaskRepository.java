package com.bancoInter.repository;

import org.springframework.data.repository.CrudRepository;

import com.bancoInter.entity.TaskEntity;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

	TaskEntity findOne(Long id);
}

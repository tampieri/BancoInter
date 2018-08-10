package com.bancoInter.repository;

import org.springframework.data.repository.CrudRepository;

import com.bancoInter.entity.JobEntity;

public interface jobRepository extends CrudRepository<JobEntity, Long> {

	JobEntity findOne(Long id);

}

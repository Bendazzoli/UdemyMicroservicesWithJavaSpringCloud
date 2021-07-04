package com.udemy.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}

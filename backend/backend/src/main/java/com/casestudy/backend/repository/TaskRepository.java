package com.casestudy.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.backend.model.Tasks;

@Repository
public interface TaskRepository extends CrudRepository<Tasks, Integer> {
	List<Tasks> findByParent(int parent);
	List<Tasks> findByIsProject(Boolean isProject);
}

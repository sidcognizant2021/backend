package com.casestudy.backend.repository;

import com.casestudy.backend.model.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends CrudRepository<Tasks, Integer> {

}

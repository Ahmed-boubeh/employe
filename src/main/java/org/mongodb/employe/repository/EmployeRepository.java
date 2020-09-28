package org.mongodb.employe.repository;

import org.mongodb.employe.model.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeRepository extends MongoRepository<Employe, Integer> {

}

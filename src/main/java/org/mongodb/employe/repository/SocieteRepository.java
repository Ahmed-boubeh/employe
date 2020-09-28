package org.mongodb.employe.repository;


import org.mongodb.employe.model.Societe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocieteRepository extends MongoRepository<Societe, Integer> {

}

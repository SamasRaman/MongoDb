package com.exilant.training.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exilant.training.model.Person;

public interface PersonRepository extends MongoRepository<Person,Integer>{

}

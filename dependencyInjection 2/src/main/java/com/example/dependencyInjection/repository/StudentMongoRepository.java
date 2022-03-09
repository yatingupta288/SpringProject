package com.example.dependencyInjection.repository;

import com.example.dependencyInjection.Entity.StudentEntity;
import com.example.dependencyInjection.Entity.StudentMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentMongoRepository extends CrudRepository<StudentMongo,String> {
}

package com.example.dependencyInjection.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Student")
public class StudentMongo {
    @Id
    Long id;


    String name;

    public StudentMongo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentMongo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

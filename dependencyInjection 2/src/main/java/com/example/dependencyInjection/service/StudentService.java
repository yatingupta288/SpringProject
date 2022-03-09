package com.example.dependencyInjection.service;

import com.example.dependencyInjection.Entity.StudentEntity;
import com.example.dependencyInjection.Entity.StudentMongo;
import com.example.dependencyInjection.dto.Student;

import java.util.List;

public interface StudentService {
//    List<StudentMongo> getAllStudents();
//    StudentMongo getStudent(Long id);
//    StudentMongo getStudent(Long id, String name);
//    void addStudent(StudentMongo student);
//    void update(StudentMongo Student);
//    void delete(StudentMongo student);

    List<Student> getAllStudents();
    Student getStudent(Long id);
    Student getStudent(Long id, String name);
    void addStudent(Student student, Long num);
    void update(Student Student, Long num);
    void delete(Student student, Long num);
}


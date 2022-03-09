package com.example.dependencyInjection.Controller;

import com.example.dependencyInjection.Entity.StudentMongo;
import com.example.dependencyInjection.dto.Student;
import com.example.dependencyInjection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

//    @GetMapping(value = "/student", produces = "application/json")
//    public List<StudentMongo> getStudent(){
//        return studentService.getAllStudents();
//    }
//
////    @GetMapping(value = "/studentparam", produces = "application/json")
////    public Student getStudent(@RequestParam Long id, @RequestParam String name){
////        return studentService.getStudent(id, name);
////    }
//
//    @PostMapping(value = "/students", consumes = "application/json")
//    public void addStudent(@RequestBody @Valid StudentMongo student){
//        studentService.addStudent(student);
//    }
//
//    @PutMapping(value = "/studentsUpdate", consumes = "application/json")
//    public void update(@RequestBody @Valid StudentMongo student){
//        studentService.update(student);
//    }
//
//    @DeleteMapping(value = "/studentDelete", consumes = "application/json")
//    public void delete(@RequestBody @Valid StudentMongo student){ studentService.delete(student);}


    @GetMapping(value = "/student", produces = "application/json")
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/studentparam", produces = "application/json")
    public Student getStudent(@RequestParam Long id, @RequestParam String name){
        return studentService.getStudent(id, name);
    }

    @PostMapping(value = "/students", consumes = "application/json")
    public void addStudent(@RequestBody @Valid Student student, @RequestParam Long num){
        studentService.addStudent(student, num);
    }

    @PutMapping(value = "/studentsUpdate", consumes = "application/json")
    public void update(@RequestBody @Valid Student student, @RequestParam Long num){
        studentService.update(student, num);
    }

    @DeleteMapping(value = "/studentDelete", consumes = "application/json")
    public void delete(@RequestBody @Valid Student student, @RequestParam Long num){ studentService.delete(student, num);}

}

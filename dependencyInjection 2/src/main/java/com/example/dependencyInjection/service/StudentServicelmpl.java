package com.example.dependencyInjection.service;

import com.example.dependencyInjection.Entity.StudentEntity;
import com.example.dependencyInjection.Entity.StudentMongo;
import com.example.dependencyInjection.dto.Student;
import com.example.dependencyInjection.repository.StudentMongoRepository;
import com.example.dependencyInjection.repository.StudentRedisRepository;
import com.example.dependencyInjection.repository.StudentRepository;
import com.example.dependencyInjection.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicelmpl implements StudentService{
    @Autowired
    Studentdb studentdb;

    @Autowired
    StudentRepository StudentRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;
//    ------------------------------------------------------MONGODB------------------------------------------------------
//    @Override
    //    public List<StudentMongo> getAllStudents(){
////        Iterable<StudentEntity> studentEntityList = StudentRepository.findAll();
////        List<Student> studentResponseList = new ArrayList<>();
////        for(StudentEntity studentEntity : studentEntityList){
////            Student student = new Student(studentEntity.getId(), studentEntity.getName());
////            student.setId(studentEntity.getId());
////            student.setfName(studentEntity.getName());
////            studentResponseList.add(student);
////        }
////        return studentResponseList;
//        Iterable<StudentMongo> studentEntityList = studentMongoRepository.findAll();
//        List<StudentMongo> studentResponseList = new ArrayList<>();
//        for(StudentMongo studentMongo : studentEntityList){
//            studentResponseList.add(studentMongo);
//        }
//        return studentResponseList;
//
//    }
//
////    @Override
////    public StudentMongo getStudent(Long id){
//////        for(Student student : studentdb.getStudentList()){
//////            if(student.getId()==id){
//////                return student;
//////            }
//////        }
////        Optional<StudentMongo> studentMongoEntity = studentMongoRepository.findById(id.toString());
//////        List<Student> studentResponseList = new ArrayList<>();
////        if(studentMongoEntity.isPresent()){
////            return new StudentMongo(studentMongoEntity.get().getId(), studentMongoEntity.get().getName());
////        }
////        return null;
////    }
//
////    @Override
////    public StudentMongo getStudent(Long id, String name){
////        for(Student student : studentdb.getStudentList()){
////            if(student.getId()==id && student.getfName().equals(name)){
////                return student;
////            }
////        }
////        return null;
////    }
//
//    @Override
//    public void addStudent(StudentMongo student){
//        studentMongoRepository.save(new StudentMongo(student.getId(), student.getName()));
//    }
//
//    @Override
//    public void update(StudentMongo student){
//        studentMongoRepository.save(student);
//    }
//
//    @Override
//    public void delete(StudentMongo student){
//        studentMongoRepository.delete(student);
//    }


// ---------------------------------------------------------------POSTGRES----------------------------------------
//    @Override
//    public List<Student> getAllStudents(){
//        return studentRedisRepository.findAll();
//    }
//    @Override
//    public void addStudent(Student student){
//        studentRedisRepository.insert(student);
//    }
//    @Override
//    public void update(Student student){
//        studentRedisRepository.insert(student);
//    }
//    @Override
//    public void delete(Student student){
//        studentRedisRepository.deleteOne(student.getId());
//    }
//    @Override
//    public Student getStudent(Long id){
//        return studentRedisRepository.findOne(String.valueOf(id));
////        return studentRedisRepository.findOne(String.valueOf(id));
//    }
@Override
    public List<Student> getAllStudents(){

    List<Student> studentResponseList = new ArrayList<>();
    for(Student student :studentdb.getStudentList()){
        studentResponseList.add(student);
    }
    Iterable<StudentEntity> studentEntityList = StudentRepository.findAll();
        for(StudentEntity studentEntity : studentEntityList){
            Student student = new Student(studentEntity.getId(), studentEntity.getName());
            student.setId(studentEntity.getId());
            student.setfName(studentEntity.getName());
            studentResponseList.add(student);
        }
        Iterable<StudentMongo> studentEntityList1 = studentMongoRepository.findAll();
        for(StudentMongo studentMongo : studentEntityList1){
            Student student = new Student(studentMongo.getId(), studentMongo.getName());
            student.setId(studentMongo.getId());
            student.setfName(studentMongo.getName());
            studentResponseList.add(student);
        }
        List<Student> newList = studentRedisRepository.findAll();
        for(Student student : newList){
            studentResponseList.add(student);
        }
        return studentResponseList;

    }

    @Override
    public Student getStudent(Long id){
        for(Student student : studentdb.getStudentList()){
            if(student.getId() == id){
                return student;
            }
        }
        Optional<StudentEntity> studentEntity = StudentRepository.findById(id);
        if(studentEntity.isPresent()){
            return new Student(studentEntity.get().getId(), studentEntity.get().getName());
        }

        Optional<StudentMongo> studentMongoEntity = studentMongoRepository.findById(id.toString());
        if(studentMongoEntity.isPresent()){
            return new Student(studentMongoEntity.get().getId(), studentMongoEntity.get().getName());
        }

        return studentRedisRepository.findOne(String.valueOf(id));

    }

    @Override
    public Student getStudent(Long id, String name){
        for(Student student : studentdb.getStudentList()){
            if(student.getId() == id){
                return student;
            }
        }
        Iterable<StudentEntity> studentEntityList = StudentRepository.findAll();
        for(StudentEntity studentEntity : studentEntityList){
            if(studentEntity.getId()== id && studentEntity.getName().equals(name)){
                return new Student(studentEntity.getId(), studentEntity.getName());
            }
        }

        Iterable<StudentMongo> studentMongoEntityList= studentMongoRepository.findAll();
        for(StudentMongo studentMongoEntity : studentMongoEntityList){
            if(studentMongoEntity.getId()== id && studentMongoEntity.getName().equals(name)){
                return new Student(studentMongoEntity.getId(), studentMongoEntity.getName());
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student,Long num){
    if(num == 1){
        studentdb.getStudentList().add(student);
    }else if(num == 2){
        studentMongoRepository.save(new StudentMongo(student.getId(), student.getfName()));
    }else if(num == 3){
        StudentRepository.save(new StudentEntity(student.getId(),student.getfName()) );
    }else if(num == 4){
        studentRedisRepository.insert(student);
    }else{

    }

    }

    @Override
    public void update(Student student, Long num){

    if(num == 1){
        for(Student s : studentdb.getStudentList()){
            if(s.getId() == student.getId()){
                studentdb.getStudentList().remove(s);
                studentdb.getStudentList().add(student);
                break;
            }
        }
    }else if(num == 2){
        studentMongoRepository.save(new StudentMongo(student.getId(), student.getfName()));
    }else if(num == 3){
        StudentRepository.save(new StudentEntity(student.getId(), student.getfName()));
    }else if(num == 4){
        studentRedisRepository.save(student);
    }else{

    }
    }

    @Override
    public void delete(Student student, Long num){
    if(num == 1){

    }else if(num == 2){
        Iterable<StudentMongo> studentMongoEntityList = studentMongoRepository.findAll();
        for(StudentMongo studentMongoEntity : studentMongoEntityList){
            if(studentMongoEntity.getId()== student.getId() && studentMongoEntity.getName().equals(student.getfName())){
                studentMongoRepository.delete(studentMongoEntity);
            }
        }
    }else if(num == 3){
        Iterable<StudentEntity> studentEntityList = StudentRepository.findAll();
        for(StudentEntity studentEntity : studentEntityList){
            if(studentEntity.getId()== student.getId() && studentEntity.getName().equals(student.getfName())){
               StudentRepository.delete(studentEntity);
            }
        }
    }else if(num == 4){
        studentRedisRepository.deleteOne(student.getId());
    }
    }
//------------------------------------------------------------REDIS--------------------------------------------------
//    @Autowired
//    StudentDb studentDb;
//    @Autowired
//    StudentRepository studentRepository;
//    @Autowired
//    DepartmentDB departmentDb;
//    @Autowired
//    StudentRedisRepository studentRedisRepository;
//    //    @Autowired
////     CombinedDb combinedDb;
//    @Override
//    public List<Student> getAllStudents() {
//
//
//
//
//        studentDb.getStudentList();
//        Iterable<StudentEntity> iterator = studentRepository.findAll();
//        List<Student> studentEntities = new ArrayList<>();
//        for (StudentEntity i : iterator) {
//            Student student = new Student();
//            student.setId(i.getId());
//            student.setFname(i.getName());
//            studentEntities.add(student);
//        }
//
//
//
//        return studentRedisRepository.findAll();
//        // return student;
//    }
//
//    @Override
//    public Student getStudent(Integer id) {
//        boolean isRedis=false,isPostgres =false , isListDb =false;
//        List<Student> student1 = studentDb.getStudentList();
//        List<Student> redisStudent = studentRedisRepository.findAll();
//        Iterable<StudentEntity> iterator = studentRepository.findAll();
//        List<Student> studentEntities = new ArrayList<>();
//        for (StudentEntity i : iterator) {
//            Student student = new Student();
//            student.setId(i.getId());
//            student.setFname(i.getName());
//            studentEntities.add(student);
//        }
//
//        for(Student s : student1){
//            if(s.getId()==id){
//                isListDb = true;
//                break;
//            }
//        }
//
//        for(Student s : studentEntities){
//            if(s.getId() == id){
//                isPostgres = true;
//                break;
//            }
//        }
//
//        for(Student s : redisStudent){
//            if(s.getId() == id){
//                isRedis = true;
//                break;
//            }
//        }
//
//
//
//        if(isListDb){
//            System.out.println("hrllooo");
//            Log.info("IN HELLO in list");
//            return studentDb.getStudentById(id);
//        }else if(isPostgres){
//            System.out.println("hello in postgres");
//            for(Student s : studentEntities){
//                if(s.getId() == id){
//                    return s;
//                }
//            }
//
//        }else if(isRedis){
//            for(Student s : redisStudent){
//                if(s.getId() == id){
//                    return s;
//                }
//            }
//        }
////        System.out.println("heeloooo");
////        Log.info("IN HELLO");
//        return null;
//    }
//
//
//
//    @Override
//    public void addStudent(Student student , Integer i) {
////        studentRepository.save(new StudentEntity(student.getFname()));
////        studentDb.addStudent(student);
//        if(i==1){
//            studentDb.addStudent(student);
//        }else if(i==2){
//            studentRepository.save(new StudentEntity(student.getId() , student.getFname()));
//        }else if(i==3){
//            studentRedisRepository.addStudent(student);
//        }
//
//
//    }

}

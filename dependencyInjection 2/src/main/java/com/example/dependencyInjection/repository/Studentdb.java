package com.example.dependencyInjection.repository;

import com.example.dependencyInjection.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Studentdb {
    public  ArrayList<Student> slist = new ArrayList<>();


    public List<Student> getStudentList(){
        if(slist.size() == 0) {
            Studentdb sdb = new Studentdb();
            Student s = new Student((long) 1, "yatin","gupta", "IT");
            Student s1 = new Student((long) 2, "yatin","gupta", "IT");
            Student s2 = new Student((long) 3, "yatin","gupta", "IT");
            Student s3 = new Student((long) 4, "yatin","gupta", "IT");
            slist.add(s);
            slist.add(s1);
            slist.add(s2);
            slist.add(s3);
        }

       return slist;
    }

}

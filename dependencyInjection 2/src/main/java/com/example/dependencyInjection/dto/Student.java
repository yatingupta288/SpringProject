package com.example.dependencyInjection.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotNull
    private Long id;
    @NotBlank
    private String fName;
    private String lName;
    private String branch;
//    private String department_id;
    public Student(){

    }


    public Student(Long id, String fName, String lName, String branch) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.branch = branch;
//        this.department_id = department_id;
    }

    public Student(Long id, String name) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}

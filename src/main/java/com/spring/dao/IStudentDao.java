package com.spring.dao;

import com.spring.model.Student;

public interface IStudentDao {
    public void saveStudent(Student student);
    public  Student getStudent(int id);
    public void  updateStudent(Student student);

}

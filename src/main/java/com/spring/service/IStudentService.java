package com.spring.service;

import com.spring.dao.IStudentDao;
import com.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface IStudentService {


    public  void registerStudent(Student student);

    public Student getStudent(int id);

    public  void updateStudent(Student student);
}

package com.spring.service;

import com.spring.dao.IStudentDao;
import com.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentDao studentDao;
    public void registerStudent(Student student) {
studentDao.saveStudent(student);
    }

    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
}

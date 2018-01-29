package com.spring.dao;

import com.spring.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import javax.persistence.Table;
import java.awt.*;

@Repository
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    SessionFactory sessionFactory;

    Student student;

    private Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }


    @Transactional
    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    public Student getStudent(int id) {
            Session session=getCurrentSession();
      Student  s=session.get(Student.class,id);
        System.out.println(s);
            return s;
    }

    @Transactional
    public void updateStudent(Student student) {
        Session session =  sessionFactory.getCurrentSession();
            session.update(student);
    }


}

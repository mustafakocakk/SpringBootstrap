    package com.spring.conroller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Student;
import com.spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.Map;


@Controller
public class StudentController {

    private static  final Logger logger=Logger.getLogger(StudentController.class);

    @Autowired
    IStudentService studentService;



    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student() {
        if(logger.isDebugEnabled()){logger.debug("welcome is excuted");}


        return "index";

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam(value = "name")String name,
                       @RequestParam(value = "surname")String surname,
                       @RequestParam(value = "age") String age,
                       ModelMap modelMap)
    {
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(Integer.parseInt(age));
        studentService.registerStudent(student);
        return "index";
    }


    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public @ResponseBody String getir(@RequestParam(value = "id") String id){
        ObjectMapper mapper = new ObjectMapper();
        Student student=new Student();
        student=studentService.getStudent(Integer.parseInt(id));
        String json = null;
        try {
            json = mapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam(value = "name")String name,
                       @RequestParam(value = "surname")String surname,
                       @RequestParam(value = "age") String age,
                       @RequestParam(value = "id") String id
                      )
    {

        Student studentUpdate=new Student();
        studentUpdate.setName(name);
        studentUpdate.setSurname(surname);
        studentUpdate.setAge(Integer.parseInt(age));
        studentUpdate.setId(Integer.parseInt(id));
        System.out.println(studentUpdate.getId());
        studentService.updateStudent(studentUpdate);

        return "index";
    }


}

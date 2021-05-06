package com.test.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.example.entity.Student;
import com.test.example.repository.StudentRepository;

@RestController
@RequestMapping("api")
public class StudentController{
	
	@Autowired
    private StudentRepository studentRepository;

   @RequestMapping(value = "student", method = RequestMethod.POST)
    public ResponseEntity<Student> createCategory(@RequestBody Student student) {
	   studentRepository.save(student);
        return ResponseEntity.ok(student);
    }
   
   
   @RequestMapping(value = "/student/getList", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put("item", studentRepository.findAll());

        return result;
    }
  
   
     @GetMapping("/student/{studentId}")
	  public Student getOne(@PathVariable Long studentId) {
	     Student student = studentRepository.findOne(studentId);
		 return student;
	    }
     
      @DeleteMapping("/std/{studentId}")
	  public ResponseEntity<Void> deleteId(@PathVariable Long studentId) {     
    	  studentRepository.delete(studentId);
	        return ResponseEntity.noContent().build();
	    }

}

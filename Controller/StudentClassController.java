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

import com.test.example.entity.StudentClass;
import com.test.example.repository.StudentClassRepository;

@RestController
@RequestMapping("api")
public class StudentClassController {
	
	@Autowired
    private StudentClassRepository studentClassRepository;

   @RequestMapping(value = "studentClass", method = RequestMethod.POST)
    public ResponseEntity<StudentClass> createCategory(@RequestBody StudentClass studentClass) {
	   studentClassRepository.save(studentClass);
        return ResponseEntity.ok(studentClass);
    }
   
   
   @RequestMapping(value = "/studentClass/getList", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put("item", studentClassRepository.findAll());

        return result;
    }
  
   
     @GetMapping("/studentClass/{id}")
	  public StudentClass getOne(@PathVariable Long id) {
	     StudentClass stdClass = studentClassRepository.findOne(id);
		 return stdClass;
	    }
     
      @DeleteMapping("/std/{id}")
	  public ResponseEntity<Void> deleteId(@PathVariable Long id) {     
    	  studentClassRepository.delete(id);
	        return ResponseEntity.noContent().build();
	    }


}

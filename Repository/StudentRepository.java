package com.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.example.entity.Student;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {


}
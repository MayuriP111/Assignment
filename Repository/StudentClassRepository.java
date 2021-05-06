package com.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.example.entity.StudentClass;

@Repository("StudentClassRepository")
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {


}

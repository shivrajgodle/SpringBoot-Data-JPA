package com.shivraj.springdatajpa.repository;

import com.shivraj.springdatajpa.entity.Course;
import com.shivraj.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveTeacher(){

        Course course = Course.builder().title("Spring Boot").credit(100).build();

        Course course1 = Course.builder().title("Angular").credit(500).build();

        Teacher teacher = Teacher.builder().firstname("shubham").lastname("sharma")
               // .courses(List.of(course,course1))
                .build();

        teacherRepository.save(teacher);

    }

}
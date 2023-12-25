package com.shivraj.springdatajpa.repository;

import com.shivraj.springdatajpa.entity.Course;
import com.shivraj.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder().title("React").credit(6).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.shivrajgodle.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("Courses:-"+courseMaterials);
    }


}
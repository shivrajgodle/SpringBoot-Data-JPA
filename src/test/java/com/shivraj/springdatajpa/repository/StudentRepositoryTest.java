package com.shivraj.springdatajpa.repository;

import com.shivraj.springdatajpa.entity.Guardian;
import com.shivraj.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().
                emailId("jhon@gmail.com").
                firstName("Samuel").
                lastName("dixit")
               // .guardianName("jonardon").
               // guardianEmail("jonarden@gmail.com").
               // guardingMobile("9848575788")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("jonarden1@gmail.com")
                .name("jonardon")
                .mobile("9848575788")
                .build();

        Student student = Student.builder().
                emailId("shivraj1@gmail.com").
                firstName("shivraj").
                lastName("godle")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }



    @Test
    public void getStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentByName(){

        List<Student> students = studentRepository.findStudentByFirstName("shivraj");

        System.out.println(students);
    }

    @Test
    public void getStudentByContainingName(){

        List<Student> students = studentRepository.findStudentByFirstNameContaining("shiv");

        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> student = studentRepository.findByGuardianName("jonardon");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("shivraj1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("shivraj1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shivraj1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shivraj1@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("shiv","shivraj1@gmail.com");
    }

}
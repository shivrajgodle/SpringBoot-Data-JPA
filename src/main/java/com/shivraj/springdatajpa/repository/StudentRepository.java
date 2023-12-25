package com.shivraj.springdatajpa.repository;

import com.shivraj.springdatajpa.entity.Guardian;
import com.shivraj.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findStudentByFirstName(String firstName);

     List<Student> findStudentByFirstNameContaining(String firstName);

     List<Student> findStudentByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);


    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //native Query
    @Query(value = "SELECT * FROM tbl_student s where s.email_address = ?1",nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    //native named param query
    @Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId",nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value="update tbl_student set first_name = ?1 where email_address = ?2",nativeQuery = true)
    int updateStudentNameByEmailId(String firstName,String emailId);


}

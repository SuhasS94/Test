package com.example.demo.repo;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s where s.name = ?1")
    Optional<Student> findUserByName(String name);

    @Query("SELECT s FROM Student s where s.id = ?1")
    Optional<Student> findUserByID(Long id);
}

package com.example.demo.Repository;


import com.example.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    boolean existsByUserId(Long id);

}
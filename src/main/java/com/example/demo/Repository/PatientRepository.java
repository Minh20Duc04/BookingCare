package com.example.demo.Repository;


import com.example.demo.Model.Patient;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUser(User user);

    @Query("SELECT p FROM Patient p JOIN FETCH p.appointments WHERE p.user = :user")
    Optional<Patient> findByUserWithAppointments(@Param("user") User user);
}

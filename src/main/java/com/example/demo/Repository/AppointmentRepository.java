package com.example.demo.Repository;


import com.example.demo.Model.Appointment;
import com.example.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor docDB, LocalDate date, LocalTime startTime);

    List<Appointment> findAllByDoctor(Doctor docDB);
}

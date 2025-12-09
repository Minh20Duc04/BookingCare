package com.example.demo.Repository;


import com.example.demo.Model.Doctor;
import com.example.demo.Model.Patient;
import com.example.demo.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByPatientAndDoctor(Patient patient, Doctor doctor);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.doctor.id = :doctorId")
    Double findAverageRatingByDoctorId(@Param("doctorId") Long doctorId);
}

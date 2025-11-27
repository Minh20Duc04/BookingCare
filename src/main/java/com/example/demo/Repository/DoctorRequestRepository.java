package com.example.demo.Repository;


import com.example.demo.Model.DoctorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRequestRepository extends JpaRepository<DoctorRequest, Long> {

}

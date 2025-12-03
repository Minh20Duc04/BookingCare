package com.example.demo.Service;

import com.example.demo.Dto.DoctorDecisionDto;
import com.example.demo.Model.Doctor;

public interface DoctorService {
    String decideDoctorRequest(DoctorDecisionDto decisionDto);

    Doctor findByDoctorName(String name);

}

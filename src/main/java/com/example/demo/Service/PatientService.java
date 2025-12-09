package com.example.demo.Service;


import com.example.demo.Dto.PatientDto;
import com.example.demo.Model.User;

import java.util.List;

public interface PatientService {

    List<PatientDto> getAllPatients();

    String updatePatient(User user, Long patientId, PatientDto patientDto);

    String deletePatient(Long patientId);

    PatientDto getPatientProfile(User user);
}

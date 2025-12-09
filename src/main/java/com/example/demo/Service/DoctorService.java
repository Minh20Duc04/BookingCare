package com.example.demo.Service;

import com.example.demo.Dto.DoctorDecisionDto;
import com.example.demo.Dto.DoctorDto;
import com.example.demo.Dto.DoctorRequestDto;
import com.example.demo.Model.User;

import java.util.List;

public interface DoctorService {

    String decideDoctorRequest(DoctorDecisionDto decisionDto);

    String updateDoctor(Long doctorId, DoctorRequestDto doctorRequestDto);

    List<DoctorDto> findByDoctorNameOrSpecialty(String name, String specialty, String page);

    DoctorDto getDoctorProfile(User user);

    DoctorDto getDoctorById(Long id);

    List<DoctorDto> getAllDoctor();
}

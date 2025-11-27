package com.example.demo.Service;


import com.example.demo.Dto.DoctorRequestDto;
import com.example.demo.Model.User;

public interface DoctorRequestService {
    DoctorRequestDto createDoctorRequest(DoctorRequestDto doctorRequestDto, User user);


}

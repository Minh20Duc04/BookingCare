package com.example.demo.Service;


import com.example.demo.Dto.DoctorRequestDto;
import com.example.demo.Model.User;

import java.util.List;

public interface DoctorRequestService {
    DoctorRequestDto createDoctorRequest(DoctorRequestDto doctorRequestDto, User user);

    List<DoctorRequestDto> getAllDoctorRequests();

}

package com.example.demo.Service;


import com.example.demo.Dto.DoctorRequestDto;
import com.example.demo.Model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DoctorRequestService {
    DoctorRequestDto createDoctorRequest(DoctorRequestDto doctorRequestDto, User user, MultipartFile file);

    List<DoctorRequestDto> getAllDoctorRequests();

}

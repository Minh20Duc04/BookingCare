package com.example.demo.Service.ServiceImp;

import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.DoctorRequestRepository;
import com.example.demo.Repository.ScheduleRepository;
import com.example.demo.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorRequestRepository doctorRequestRepository;
    private final ScheduleRepository scheduleRepository;






}

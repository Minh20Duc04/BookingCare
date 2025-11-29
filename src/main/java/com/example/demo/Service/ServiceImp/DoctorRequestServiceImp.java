package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.DoctorRequestDto;
import com.example.demo.Model.*;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DoctorRequestRepository;
import com.example.demo.Service.DoctorRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorRequestServiceImp implements DoctorRequestService {

    private final DoctorRequestRepository doctorRequestRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public DoctorRequestDto createDoctorRequest(DoctorRequestDto doctorRequestDto, User user) {
        validateRequest(doctorRequestDto);

        Specialty specialty = Specialty.valueOf(doctorRequestDto.getSpecialty().toUpperCase());

        Department department = departmentRepository.findById(doctorRequestDto.getDepartmentId()).orElseThrow(()-> new IllegalArgumentException("This Department not exist"));

        Set<DayOfWeek> days = doctorRequestDto.getDaysOfWeek()
                .stream()
                .map(String::toUpperCase)
                .map(DayOfWeek::valueOf)
                .collect(Collectors.toSet());
        return doctorRequestDto;
    }

    @Override
    public List<DoctorRequestDto> getAllDoctorRequests() {
        List<DoctorRequest> doctorRequests = doctorRequestRepository.findAll();
        List<DoctorRequestDto> doctorRequestDtos = doctorRequests.stream().map(this::docRequestToDto).collect(Collectors.toList());
        return doctorRequestDtos;
    }


    private void validateRequest(DoctorRequestDto doctorRequestDto){
        try {
            Specialty.valueOf(doctorRequestDto.getSpecialty().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid specialty: " + doctorRequestDto.getSpecialty());
        }

        for(String day : doctorRequestDto.getDaysOfWeek()) {
            try {
                DayOfWeek.valueOf(day.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid day of week: " + day);
            }
        }

        if(doctorRequestDto.getStartTime() == null || doctorRequestDto.getEndTime() == null) {
            throw new IllegalArgumentException("Start time and end time cannot be null");
        }

        if(doctorRequestDto.getStartTime().isAfter(doctorRequestDto.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

    }


    private DoctorRequestDto docRequestToDto(DoctorRequest doctorRequest){
        return new DoctorRequestDto(doctorRequest.getId(), doctorRequest.getStatus().name(), doctorRequest.getSpecialty().name(), doctorRequest.getDaysOfWeek().stream().map(DayOfWeek::name).collect(Collectors.toList()), doctorRequest.getDepartment().getId(), doctorRequest.getStartTime(), doctorRequest.getEndTime());
    }




}
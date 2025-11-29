package com.example.demo.Service.ServiceImp;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.DoctorRequest;
import com.example.demo.Model.Role;
import com.example.demo.Model.Status;
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


    @Override
    public String decideDoctorRequest(Long doctorRequestId, String status) {
        DoctorRequest doctorRequest = doctorRequestRepository.findById(doctorRequestId).orElseThrow(()-> new RuntimeException("Can't find this doctor request"));
        Status seekStatus;
        try {
            seekStatus = Status.valueOf(status.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid status");
        }

        if(seekStatus.equals(Status.APPROVED)){
            boolean checkExistedDoc = doctorRepository.existsByUserId(doctorRequest.getUser().getId());
            if(checkExistedDoc){
                throw new IllegalStateException("User is already a doctor");
            }

            Doctor createDoctor = Doctor.builder()
                    .fullName(doctorRequest.getUser().getFirstName() + " "+doctorRequest.getUser().getLastName())
                    .specialty(doctorRequest.getSpecialty())
                    .role(Role.DOCTOR)
                    .department(doctorRequest.getDepartment())
                    .user(doctorRequest.getUser())
                    .build();
            doctorRepository.save(createDoctor);


            doctorRequest.setStatus(Status.APPROVED);
            doctorRequestRepository.save(doctorRequest);
            return "Doctor request approved successfully";
        }
        else if(seekStatus == Status.PENDING){
            return "Doctor request is still pending";
        }
        else {
            doctorRequest.setStatus(Status.REJECTED);
            doctorRequestRepository.save(doctorRequest);
            return "Doctor request rejected.";
        }
    }
}
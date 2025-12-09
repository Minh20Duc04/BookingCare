package com.example.demo.Dto;

import com.CareBook.MediSched.Model.Doctor;
import com.CareBook.MediSched.Model.Patient;
import com.CareBook.MediSched.Model.PaymentMethod;
import com.CareBook.MediSched.Model.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String note;
    private Status status;
    
    // Patient information
    private String patientName;
    private String patientPhone;
    private String patientEmail;
    private Integer patientAge;
    
    // Doctor information
    private String doctorName;
    private String doctorSpecialty;
    private String departmentName;
    
    // Appointment details
    private String reason;
    private Boolean hasReview;
    
    @NotNull
    private PaymentMethod paymentMethod;
}

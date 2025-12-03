package com.example.demo.Service;

import com.example.demo.Dto.AppointmentDto;
import com.example.demo.Model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date);

    AppointmentDto bookAppointment(AppointmentDto appointmentDto, User user);




}
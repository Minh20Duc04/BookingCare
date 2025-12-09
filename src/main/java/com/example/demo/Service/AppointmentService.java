package com.example.demo.Service;


import com.example.demo.Dto.AppointmentDto;
import com.example.demo.Model.Appointment;
import com.example.demo.Model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date);

    AppointmentDto bookAppointment(AppointmentDto appointmentDto, User user);


    List<AppointmentDto> getAllByDoc(User user);

    String updateAppointment(Long appointmentId, User user, String status, String note);;

    List<AppointmentDto> getAppointmentsByUser(User user);

    String createVnPayUrl(Appointment appointment);
    Appointment getAppointmentById(Long id);

    List<AppointmentDto> getAllAppointments();
}

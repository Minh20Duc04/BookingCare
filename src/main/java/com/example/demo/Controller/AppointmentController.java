package com.example.demo.Controller;

import com.example.demo.Dto.AppointmentDto;
import com.example.demo.Model.User;
import com.example.demo.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/available-slots")
    public ResponseEntity<List<LocalTime>> getAvailableSlots(@RequestParam Long doctorId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(appointmentService.getAvailableSlots(doctorId, date));
    }

    @PostMapping("/book") //cho patient, user
    public ResponseEntity<AppointmentDto> bookAppointment(@RequestBody AppointmentDto appointmentDto, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(appointmentService.bookAppointment(appointmentDto, user));
    }


}







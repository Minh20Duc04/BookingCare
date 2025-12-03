package com.example.demo.Repository;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule findByDoctorAndDaysOfWeekContaining(Doctor docDB, DayOfWeek dayOfWeek);

}

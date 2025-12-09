package com.example.demo.Service;



import com.example.demo.Dto.ReviewDto;
import com.example.demo.Model.User;

import java.util.List;

public interface ReviewService {
    String evaluateDoc(User user, ReviewDto reviewDto);

    List<ReviewDto> getAllById(Long doctorId);
}

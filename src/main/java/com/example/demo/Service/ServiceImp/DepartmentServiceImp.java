package com.example.demo.Service.ServiceImp;


import com.example.demo.Model.Department;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(String name, String description) {
        if(departmentRepository.existsByNameAndDescription(name,description)){
            throw new IllegalArgumentException("Department with this information already exists");
        }

        Department newDepartment = Department.builder()
                .name(name)
                .description(description)
                .build();

        return departmentRepository.save(newDepartment);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}

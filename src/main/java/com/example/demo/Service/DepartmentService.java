package com.example.demo.Service;


import com.example.demo.Model.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(String name, String description);

    List<Department> getAll();
}

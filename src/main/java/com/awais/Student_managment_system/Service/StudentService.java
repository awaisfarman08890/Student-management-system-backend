package com.awais.Student_managment_system.Service;


import com.awais.Student_managment_system.Dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getstudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudentById(Long studentId);
}

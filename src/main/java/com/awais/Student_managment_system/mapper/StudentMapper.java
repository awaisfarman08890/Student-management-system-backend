package com.awais.Student_managment_system.mapper;

import com.awais.Student_managment_system.Dto.StudentDto;
import com.awais.Student_managment_system.Entity.Student;

public class StudentMapper {
    public static StudentDto maptoStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
        return studentDto;

    }
    public static Student maptoStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstname(),
                studentDto.getLastname(),
                studentDto.getEmail()
        );
        return student;

    }
}

package com.awais.Student_managment_system.Service.Impl;

import com.awais.Student_managment_system.Dto.StudentDto;
import com.awais.Student_managment_system.Entity.Student;
import com.awais.Student_managment_system.Repository.StudentRepository;
import com.awais.Student_managment_system.Service.StudentService;
import com.awais.Student_managment_system.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class StudentServiceImplement implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(StudentMapper::maptoStudentDto).toList();
        return studentDtos;

    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.maptoStudent(studentDto);
        studentRepository.save(student);

    }

    @Override
    public StudentDto getstudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.maptoStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.maptoStudent(studentDto));

    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

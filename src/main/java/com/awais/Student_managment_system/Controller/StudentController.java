package com.awais.Student_managment_system.Controller;

import com.awais.Student_managment_system.Dto.StudentDto;
import com.awais.Student_managment_system.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    //handler method to handle list students request
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
      // student model object to store student from data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }
    //handler method to handle save student submit request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult bindingResult,
                              Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            return "create_student";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }
    //handle method to handle edit student method
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto student = studentService.getstudentById(studentId);
        model.addAttribute("student", student);
        return "edit_student";

    }
    //handler method to handle edit student submit request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()) {
            model.addAttribute("student", studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";

    }
    //handler method to handle delete student request
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudentById(studentId);
        return "redirect:/students";
    }
    // Handler method to handle view student request
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto student = studentService.getstudentById(studentId);
        model.addAttribute("student", student);
        return "view_student";
    }



}

package com.awais.Student_managment_system.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "Student first name should not be empty")
    private String firstname;
    @NotEmpty(message = "Student last name should not be empty")
    private String lastname;
    @NotEmpty(message = "Student email should not be empty")
    @Email
    private String email;
}

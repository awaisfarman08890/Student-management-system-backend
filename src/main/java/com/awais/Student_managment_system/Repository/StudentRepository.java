package com.awais.Student_managment_system.Repository;

import com.awais.Student_managment_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

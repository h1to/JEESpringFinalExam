package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.StudentRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    StudentRepoImpl studentRepo;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddStudent() {
        when(studentRepo.save(any())).thenReturn(0);
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        int result = studentService.addStudent(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(studentRepo.update(any())).thenReturn(0);
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        int result = studentService.rename(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteStudent() {
        when(studentRepo.delete(anyLong())).thenReturn(0);
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        int result = studentService.deleteStudent(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testStudentExists() {
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        boolean result = studentService.studentExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetStudentList() {
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        List<Student> result = studentService.getStudentList();
        Assertions.assertEquals(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), result);
    }

    @Test
    void testGetStudentById() {
        when(studentRepo.findAll()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        Student result = studentService.getStudentById(Long.valueOf(1));
        Assertions.assertEquals(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
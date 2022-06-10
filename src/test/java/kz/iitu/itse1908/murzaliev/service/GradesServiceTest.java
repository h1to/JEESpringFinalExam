package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.configuration.CurrentWeekAndYear;
import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.GradesRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class GradesServiceTest {
    @Mock
    CurrentWeekAndYear currentWeekAndYear;
    @Mock
    GradesRepoImpl gradesRepo;
    @Mock
    StudentService studentService;
    @Mock
    DisciplineService disciplineService;
    @InjectMocks
    GradesService gradesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdate() {
        when(currentWeekAndYear.getWeek()).thenReturn(0);
        when(gradesRepo.update(any())).thenReturn(0);

        int result = gradesService.update(new Grades(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), Long.valueOf(1), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0)));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetGrades() {
        when(gradesRepo.findById(anyLong(), anyLong())).thenReturn(new Grades(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), Long.valueOf(1), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0)));
        when(studentService.studentExists(anyLong())).thenReturn(true);
        when(disciplineService.disciplineExists(anyLong())).thenReturn(true);

        Grades result = gradesService.getGrades(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(new Grades(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), Long.valueOf(1), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0)), result);
    }

    @Test
    void testGetGradesList() {
        when(gradesRepo.findByStudent(anyLong())).thenReturn(List.of(new Grades(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), Long.valueOf(1), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0))));
        when(studentService.getStudentList()).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        List<Grades> result = gradesService.getGradesList(Long.valueOf(1));
        Assertions.assertEquals(List.of(new Grades(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0)), Long.valueOf(1), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), Double.valueOf(0))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
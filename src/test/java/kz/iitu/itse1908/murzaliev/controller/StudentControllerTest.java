package kz.iitu.itse1908.murzaliev.controller;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class StudentControllerTest {
    @Mock
    DepartmentService departmentService;
    @Mock
    DegreeService degreeService;
    @Mock
    DisciplineService disciplineService;
    @Mock
    SpecialityService specialityService;
    @Mock
    FacultyService facultyService;
    @Mock
    RoleService roleService;
    @Mock
    UserService userService;
    @Mock
    StudentService studentService;
    @Mock
    TeacherService teacherService;
    @Mock
    GradesService gradesService;
    @InjectMocks
    StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetHeader() {
        HttpEntity<String> result = studentController.getHeader();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCollectionOptions() {
        ResponseEntity<?> result = studentController.collectionOptions();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
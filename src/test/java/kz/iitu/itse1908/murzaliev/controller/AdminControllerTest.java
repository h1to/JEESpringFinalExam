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

import static org.mockito.Mockito.*;

class AdminControllerTest {
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
    AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetHeader() {
        HttpEntity<String> result = adminController.getHeader();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCollectionOptions() {
        ResponseEntity<?> result = adminController.collectionOptions();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDefaultP() {
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.defaultP();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testChangeRole() {
        when(userService.getUserById(anyLong())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));
        when(userService.update(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.changeRole(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEditUser() {
        when(userService.update(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.editUser(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEditFaculty() {
        when(facultyService.rename(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.editFaculty(new Faculty(Long.valueOf(1), "name"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEditDegree() {
        when(degreeService.rename(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.editDegree(new Degree(Long.valueOf(1), "name"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEditDepartment() {
        when(departmentService.rename(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.editDepartment(new Department(Long.valueOf(1), "name"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEditSpeciality() {
        when(specialityService.rename(any())).thenReturn(0);
        when(userService.getByEmail(anyString())).thenReturn(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE, new User(Long.valueOf(1), null, "email", "password", Boolean.TRUE, null.kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL).kz.iitu.itse1908.murzaliev.entity.User.Provider.LOCAL));

        ResponseEntity<String> result = adminController.editSpeciality(new Speciality(Long.valueOf(1), "name", null));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
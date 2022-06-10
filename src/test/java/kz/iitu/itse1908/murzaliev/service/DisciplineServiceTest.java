package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DisciplineRepoImpl;
import kz.iitu.itse1908.murzaliev.utility.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class DisciplineServiceTest {
    @Mock
    DisciplineRepoImpl disciplineRepo;
    @Mock
    QuickSort quickSort;
    @InjectMocks
    DisciplineService disciplineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddDescipline() {
        when(disciplineRepo.save(any())).thenReturn(0);
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        int result = disciplineService.addDescipline(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(disciplineRepo.update(any())).thenReturn(0);
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        int result = disciplineService.rename(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteDescipline() {
        when(disciplineRepo.delete(anyLong())).thenReturn(0);
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        int result = disciplineService.deleteDescipline(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteDisciplineFromDS() {
        when(disciplineRepo.deleteDisciplineFromDS(anyLong())).thenReturn(0);
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        int result = disciplineService.deleteDisciplineFromDS(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteDisciplineFromDT() {
        when(disciplineRepo.deleteDisciplineFromDT(anyLong())).thenReturn(0);
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        int result = disciplineService.deleteDisciplineFromDT(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDisciplineExists() {
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        boolean result = disciplineService.disciplineExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetDesciplineList() {
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        List<Discipline> result = disciplineService.getDesciplineList();
        Assertions.assertEquals(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))), result);
    }

    @Test
    void testGetDesciplineById() {
        when(disciplineRepo.findAll()).thenReturn(List.of(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")))));

        Discipline result = disciplineService.getDesciplineById(Long.valueOf(1));
        Assertions.assertEquals(new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))), result);
    }

    @Test
    void testGetStudents() {
        when(disciplineRepo.getStudents(anyLong())).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        List<Student> result = disciplineService.getStudents(Long.valueOf(1));
        Assertions.assertEquals(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), result);
    }

    @Test
    void testGetTeachers() {
        when(disciplineRepo.getTeachers(anyLong())).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        List<Teacher> result = disciplineService.getTeachers(Long.valueOf(1));
        Assertions.assertEquals(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")), result);
    }

    @Test
    void testAddStudents() {
        when(disciplineRepo.addStudents(any(), any())).thenReturn(new int[]{0});
        when(disciplineRepo.getStudents(anyLong())).thenReturn(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))));

        int[] result = disciplineService.addStudents(List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))));
        Assertions.assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testAddTeachers() {
        when(disciplineRepo.addTeachers(any(), any())).thenReturn(new int[]{0});
        when(disciplineRepo.getTeachers(anyLong())).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        int[] result = disciplineService.addTeachers(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")), new Discipline(Long.valueOf(1), "name", List.of(new Student(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Degree(Long.valueOf(1), "name"), new Department(Long.valueOf(1), "name"), new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), Long.valueOf(1), Double.valueOf(0))), List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"))));
        Assertions.assertArrayEquals(new int[]{0}, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
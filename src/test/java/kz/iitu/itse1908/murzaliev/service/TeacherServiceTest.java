package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.entity.User;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.TeacherRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class TeacherServiceTest {
    @Mock
    TeacherRepoImpl teacherRepo;
    @InjectMocks
    TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTeacher() {
        when(teacherRepo.save(any())).thenReturn(0);
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        int result = teacherService.addTeacher(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(teacherRepo.update(any())).thenReturn(0);
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        int result = teacherService.rename(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteTeacher() {
        when(teacherRepo.delete(anyLong())).thenReturn(0);
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        int result = teacherService.deleteTeacher(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testTeacherExists() {
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        boolean result = teacherService.teacherExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetTeacherList() {
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        List<Teacher> result = teacherService.getTeacherList();
        Assertions.assertEquals(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")), result);
    }

    @Test
    void testGetTeacherById() {
        when(teacherRepo.findAll()).thenReturn(List.of(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name")));

        Teacher result = teacherService.getTeacherById(Long.valueOf(1));
        Assertions.assertEquals(new Teacher(Long.valueOf(1), new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), new Faculty(Long.valueOf(1), "name"), "name"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
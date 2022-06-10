package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.FacultyRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class FacultyServiceTest {
    @Mock
    FacultyRepoImpl facultyRepo;
    @InjectMocks
    FacultyService facultyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddFaculty() {
        when(facultyRepo.save(any())).thenReturn(0);
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        int result = facultyService.addFaculty(new Faculty(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(facultyRepo.update(any())).thenReturn(0);
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        int result = facultyService.rename(new Faculty(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testFacultyExists() {
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        boolean result = facultyService.facultyExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteFaculty() {
        when(facultyRepo.delete(anyLong())).thenReturn(0);
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        int result = facultyService.deleteFaculty(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetFacultyList() {
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        List<Faculty> result = facultyService.getFacultyList();
        Assertions.assertEquals(List.of(new Faculty(Long.valueOf(1), "name")), result);
    }

    @Test
    void testGetFacultyById() {
        when(facultyRepo.findAll()).thenReturn(List.of(new Faculty(Long.valueOf(1), "name")));

        Faculty result = facultyService.getFacultyById(Long.valueOf(1));
        Assertions.assertEquals(new Faculty(Long.valueOf(1), "name"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
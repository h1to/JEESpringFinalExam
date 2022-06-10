package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.entity.Speciality;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.SpecialityRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class SpecialityServiceTest {
    @Mock
    SpecialityRepoImpl specialityRepo;
    @InjectMocks
    SpecialityService specialityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSpeciality() {
        when(specialityRepo.save(any())).thenReturn(0);
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        int result = specialityService.addSpeciality(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(specialityRepo.update(any())).thenReturn(0);
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        int result = specialityService.rename(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteSpeciality() {
        when(specialityRepo.delete(anyLong())).thenReturn(0);
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        int result = specialityService.deleteSpeciality(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testSpecialityExists() {
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        boolean result = specialityService.specialityExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetSpecialityList() {
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        List<Speciality> result = specialityService.getSpecialityList();
        Assertions.assertEquals(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))), result);
    }

    @Test
    void testGetSpecialityById() {
        when(specialityRepo.findAll()).thenReturn(List.of(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name"))));

        Speciality result = specialityService.getSpecialityById(Long.valueOf(1));
        Assertions.assertEquals(new Speciality(Long.valueOf(1), "name", new Faculty(Long.valueOf(1), "name")), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
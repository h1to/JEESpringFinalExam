package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DegreeRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class DegreeServiceTest {
    @Mock
    DegreeRepoImpl degreeRepo;
    @InjectMocks
    DegreeService degreeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddDegree() {
        when(degreeRepo.save(any())).thenReturn(0);
        when(degreeRepo.findAll()).thenReturn(List.of(new Degree(Long.valueOf(1), "name")));

        int result = degreeService.addDegree(new Degree(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(degreeRepo.update(any())).thenReturn(0);
        when(degreeRepo.findAll()).thenReturn(List.of(new Degree(Long.valueOf(1), "name")));

        int result = degreeService.rename(new Degree(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteDegree() {
        when(degreeRepo.delete(anyLong())).thenReturn(0);
        when(degreeRepo.findAll()).thenReturn(List.of(new Degree(Long.valueOf(1), "name")));

        int result = degreeService.deleteDegree(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetDegreeList() {
        when(degreeRepo.findAll()).thenReturn(List.of(new Degree(Long.valueOf(1), "name")));

        List<Degree> result = degreeService.getDegreeList();
        Assertions.assertEquals(List.of(new Degree(Long.valueOf(1), "name")), result);
    }

    @Test
    void testGetDegreeById() {
        when(degreeRepo.findAll()).thenReturn(List.of(new Degree(Long.valueOf(1), "name")));

        Degree result = degreeService.getDegreeById(Long.valueOf(1));
        Assertions.assertEquals(new Degree(Long.valueOf(1), "name"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
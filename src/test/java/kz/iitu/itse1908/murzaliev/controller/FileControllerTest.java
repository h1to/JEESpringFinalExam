package kz.iitu.itse1908.murzaliev.controller;

import kz.iitu.itse1908.murzaliev.entity.fileService.FileInfo;
import kz.iitu.itse1908.murzaliev.entity.fileService.ResponseMessage;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.FilesStorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class FileControllerTest {
    @Mock
    FilesStorageService storageService;
    @InjectMocks
    FileController fileController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUploadFile() {
        ResponseEntity<ResponseMessage> result = fileController.uploadFile(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetListFiles() {
        when(storageService.loadAll()).thenReturn(null);

        ResponseEntity<List<FileInfo>> result = fileController.getListFiles();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetFile() {
        when(storageService.load(anyString())).thenReturn(null);

        ResponseEntity<Resource> result = fileController.getFile("filename");
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
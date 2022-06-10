package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.entity.User;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.UserRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepoImpl userRepo;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        when(userRepo.save(any())).thenReturn(0);
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        int result = userService.addUser(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(userRepo.update(any())).thenReturn(0);
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        int result = userService.rename(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteUser() {
        when(userRepo.delete(anyLong())).thenReturn(0);
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        int result = userService.deleteUser(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testUserExists() {
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        boolean result = userService.userExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetUserList() {
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        List<User> result = userService.getUserList();
        Assertions.assertEquals(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)), result);
    }

    @Test
    void testGetUserById() {
        when(userRepo.findAll()).thenReturn(List.of(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE)));

        User result = userService.getUserById(Long.valueOf(1));
        Assertions.assertEquals(new User(Long.valueOf(1), new Role(Long.valueOf(1), "name"), "email", "password", Boolean.TRUE), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
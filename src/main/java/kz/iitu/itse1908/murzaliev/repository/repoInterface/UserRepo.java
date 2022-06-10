package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.User;

import java.util.List;

public interface UserRepo {

    int save(User user);
    int update(User user);
    int delete(Long id);
    User findById(Long id);
    List<User> findAll();
    User findByEmail(String email);
}

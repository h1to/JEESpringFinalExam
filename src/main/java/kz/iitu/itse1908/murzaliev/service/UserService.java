package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.entity.User;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepoImpl userRepo;

    @Autowired
    public void setUserRepo(UserRepoImpl userRepo) {
        this.userRepo = userRepo;
    }

    public void processOAuthPostLogin(String username) {
        User existUser = userRepo.findByEmail(username);

        if (existUser.getUserId() == null) {
            existUser.setBlock(false);
            existUser.setPassword("");
            existUser.setRole(new Role(1L));
            existUser.setEmail(username);
            existUser.setProvider(User.Provider.GOOGLE);
            userRepo.save(existUser);
        }
        else {
            existUser.setProvider(User.Provider.GOOGLE);
            userRepo.update(existUser);
        }

    }

    public int addUser(User user) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(d -> d.getUserId()== user.getUserId()).findFirst();
        if (optionalUser.isPresent()) {
            return 10;
        }
        else {
            return userRepo.save(user);
        }
    }

    public int rename(User user) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(d -> d.getUserId()== user.getUserId()).findFirst();
        if (optionalUser.isPresent()) {
            return 10;
        }
        else {
            return userRepo.update(user);
        }
    }

    public int deleteUser(Long id) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(d -> d.getUserId() == id).findFirst();
        if (optionalUser.isPresent()) {
            return userRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public boolean userExists (Long id) {
        boolean result = false;
        List<User> users = userRepo.findAll();
        Optional<User> optionalUser = users.stream().filter(s -> s.getUserId() == id).findFirst();
        if (optionalUser.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public List<User> getUserList () {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(d -> d.getUserId() == id).findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else  {
            return new User();
        }
    }
    public int update(User user) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(d -> d.getUserId() == user.getUserId()).findFirst();
        if (optionalUser.isPresent()) {
            return userRepo.update(user);
        }
        else {
            return 11;
        }
    }

    public User getByEmail(String email) {
        List<User> userList = userRepo.findAll();
        Optional<User> optionalUser = userList.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return new User();
        }
    }
}

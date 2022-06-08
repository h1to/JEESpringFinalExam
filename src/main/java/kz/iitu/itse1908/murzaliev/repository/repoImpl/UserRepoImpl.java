package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.User;
import kz.iitu.itse1908.murzaliev.extractData.UserRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("insert into sys_user (role_id,email,password,block) values (?,?,?,?)", user.getRole().getRoleId(), user.getEmail(), user.getPassword(), user.getBlock());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update sys_user set email=?, role_id=?, password=?, block=?", user.getEmail(), user.getRole().getRoleId(), user.getPassword(), user.getBlock());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from sys_user where user_id=?", id);
    }

    @Override
    public User findById(Long id) {
        try {
            return (User) jdbcTemplate.query("select * from sys_user where user_id=?", new Object[]{id}, new UserRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new User();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new UserRowMapper());
    }
}

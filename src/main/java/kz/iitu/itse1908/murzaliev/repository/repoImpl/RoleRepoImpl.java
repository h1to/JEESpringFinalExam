package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.extractData.RoleRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Repository
public class RoleRepoImpl implements RoleRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Role role) {
        return jdbcTemplate.update("insert into role (name) values (?)", role.getName());
    }

    @Override
    public int update(Role role) {
        return jdbcTemplate.update("update role set name=? where role_id=?", role.getName(), role.getRoleId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from role where role_id=?", id);
    }

    @Override
    public Role findById(Long id) throws IndexOutOfBoundsException {
        try {
            return (Role) jdbcTemplate.query("select * from role where role_id=?", new Object[]{id}, new RoleRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Role();
        }
    }

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from role", new RoleRowMapper());
    }
}

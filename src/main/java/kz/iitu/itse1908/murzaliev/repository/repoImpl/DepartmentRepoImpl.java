package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Department;
import kz.iitu.itse1908.murzaliev.extractData.DepartmentRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Repository
public class DepartmentRepoImpl implements DepartmentRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Department department) {
        return jdbcTemplate.update("insert into department (name) values (?)",
                department.getName());
    }

    @Override
    public int update(Department department) {
        return jdbcTemplate.update("update department set name=? where department_id=?",
                department.getName(),
                department.getDepartmentId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from department where department_id=?", id);
    }

    @Override
    public Department findById(Long id) throws IndexOutOfBoundsException {
        try {
            return (Department) jdbcTemplate.query("select*from department where department_id=?", new Object[]{id}, new DepartmentRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Department();
        }
    }

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query("select*from department", new DepartmentRowMapper());
    }
}

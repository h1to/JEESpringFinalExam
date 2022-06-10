package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.extractData.FacultyRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Repository
public class FacultyRepoImpl implements FacultyRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FacultyRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Faculty faculty) {
        return jdbcTemplate.update("insert into faculty (name) values (?)", faculty.getName());
    }

    @Override
    public int update(Faculty faculty) {
        return jdbcTemplate.update("update faculty set name=?", faculty.getName());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from faculty where faculty_id=?", id);
    }

    @Override
    public Faculty findById(Long id) throws IndexOutOfBoundsException {
        try {
            return(Faculty) jdbcTemplate.query("select * from faculty where faculty_id=?", new Object[]{id}, new FacultyRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Faculty();
        }
    }
    @Override
    public List<Faculty> findAll() {
        return jdbcTemplate.query("select * from faculty", new FacultyRowMapper());
    }
}

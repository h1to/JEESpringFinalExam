package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.extractData.TeacherRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Scope("singleton")
@Repository
public class TeacherRepoImpl implements TeacherRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Teacher teacher) {
        return jdbcTemplate.update("insert into teacher (name,faculty_id,user_id) values (?,?,?)",
                teacher.getName(),
                teacher.getFaculty().getFacultyId(),
                teacher.getUser().getUserId());
    }

    @Override
    public int update(Teacher teacher) {
        return jdbcTemplate.update("update teacher set name=?,faculty_id=?", teacher.getName(), teacher.getFaculty().getFacultyId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from teacher where teacher_id=?", id);
    }

    @Override
    public Teacher findById(Long id) {
        try {
            return (Teacher) jdbcTemplate.query("select * from teacher where teacher_id=?",
                    new Object[]{id},
                    new TeacherRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Teacher();
        }
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query("select * from teacher", new TeacherRowMapper());
    }
}

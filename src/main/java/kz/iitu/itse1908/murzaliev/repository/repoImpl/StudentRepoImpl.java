package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.extractData.StudentRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Scope("singleton")
@Repository
public class StudentRepoImpl implements StudentRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("insert into student (gpa,year,degree_id,department_id,speciality_id,user_id) values (?,?,?,?,?,?)",
                student.getGpa(),
                student.getYear(),
                student.getDegree().getDegreeId(),
                student.getDepartment().getDepartmentId(),
                student.getSpeciality().getSpecialityId(),
                student.getUser().getUserId());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("update student set gpa=?,year=?,degree_id=?,department_id=?,speciality_id=?,user_id=?",
                student.getStudentId(),
                student.getGpa(),
                student.getYear(),
                student.getDegree().getDegreeId(),
                student.getDepartment().getDepartmentId(),
                student.getSpeciality().getSpecialityId(),
                student.getUser().getUserId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from student where student_id=?", id);
    }

    @Override
    public Student findById(Long id) {
        try {
            return (Student) jdbcTemplate.query("select * from student where student_id=?", new Object[]{id}, new StudentRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Student();
        }
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }
}

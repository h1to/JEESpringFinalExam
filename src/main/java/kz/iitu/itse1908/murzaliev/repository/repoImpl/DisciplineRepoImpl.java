package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.DisciplineRepo;
import kz.iitu.itse1908.murzaliev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DisciplineRepoImpl implements DisciplineRepo {

    private JdbcTemplate jdbcTemplate;

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Discipline discipline) {
        int result = jdbcTemplate.update("insert into discipline (name) values (?);", discipline.getName());
        List<Discipline> disciplines = findAll();
        discipline.setDiscipline_id(disciplines.get(disciplines.size()-1).getDiscipline_id());
        List<Teacher> teachers = discipline.getTeacher();
        if (!teachers.isEmpty()) {
            addTeachers(teachers,discipline);
        }

        List<Student> students = discipline.getStudent();
        if (!students.isEmpty()) {
            addStudents(students,discipline);
        }
        return result;
    }

    @Override
    public int update(Discipline discipline) {
        return jdbcTemplate.update("update discipline set name=?", discipline.getName());
    }

    @Override
    public int[] addTeachers(List<Teacher> teachers, Discipline discipline) {
        return jdbcTemplate.batchUpdate("insert into discipline_teacher values (?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1,discipline.getDiscipline_id());
                ps.setLong(2,teachers.get(i).getTeacherId());
            }

            @Override
            public int getBatchSize() {
                return teachers.size();
            }
        });
    }

    @Override
    public int[] addStudents(List<Student> students, Discipline discipline) {
        return jdbcTemplate.batchUpdate("insert into discipline_student values (?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, discipline.getDiscipline_id());
                ps.setLong(2, students.get(i).getStudentId());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
    }



    @Override
    public int[] deleteTeachers(List<Teacher> teachers, Discipline discipline) {
        return jdbcTemplate.batchUpdate("delete from discipline_teacher where discipline_id=? and teacher_id=?", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, discipline.getDiscipline_id());
                ps.setLong(2, teachers.get(i).getTeacherId());
            }

            @Override
            public int getBatchSize() {
                return teachers.size();
            }
        });
    }

    @Override
    public int[] deleteStudents(List<Student> students, Discipline discipline) {
        return jdbcTemplate.batchUpdate("delete from discipline_student where discipline_id=? and student_id=?", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, discipline.getDiscipline_id());
                ps.setLong(2, students.get(i).getStudentId());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
    }

    @Override
    public int deleteDisciplineFromDS(Long id) {
        return jdbcTemplate.update("delete from discipline_student where discipline_id=?", id);
    }

    @Override
    public int deleteDisciplineFromDT(Long id) {
        return jdbcTemplate.update("delete from discipline_teacher where discipline_id=?", id);
    }

    @Override
    public int delete(Long id) {
        jdbcTemplate.update("delete from discipline_student where discipline_id=?", id);
        jdbcTemplate.update("delete from discipline_teacher where discipline_id=?", id);
        return jdbcTemplate.update("delete from discipline where discipline_id=?", id);
    }

    @Override
    public List<Discipline> findAll() {
        return jdbcTemplate.query("select * from discipline", ((rs, rowNum) -> new Discipline(rs.getLong(1),rs.getString(2))));
    }

    @Override
    public List<Student> getStudents(Long id) {
        List<Student> studentIds = jdbcTemplate.query("select student_id from discipline_student where discipline_id=?", new Object[]{id}, (rs, rowNum) -> new Student(rs.getLong(1)));
        studentIds.forEach(s -> {
            s = studentService.getStudentById(s.getStudentId());
        });
        return studentIds;
    }

    @Override
    public List<Teacher> getTeachers(Long id) {
        return jdbcTemplate.query("select teacher_id from discipline_teacher where discipline_id=?", new Object[]{id}, (rs, rowNum) -> new Teacher(rs.getLong(1)));
    }
}

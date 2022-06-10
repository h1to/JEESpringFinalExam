package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Grades;
import kz.iitu.itse1908.murzaliev.extractData.GradesRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.GradesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradesRepoImpl implements GradesRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GradesRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Grades grades) {
        return jdbcTemplate.update("insert into grades (" +
                "endterm," +
                "exam," +
                "final_grade," +
                "midterm," +
                "week_one," +
                "week_two," +
                "week_three," +
                "week_four," +
                "week_five," +
                "week_six," +
                "week_seven," +
                "week_nine," +
                "week_ten," +
                "week_eleven," +
                "week_twelve," +
                "week_thirteen," +
                "week_fourteen," +
                "discipline_id," +
                "student_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                grades.getEndterm(),
                grades.getExam(),
                grades.getFinalGrade(),
                grades.getMidterm(),
                grades.getWeek1(),
                grades.getWeek2(),
                grades.getWeek3(),
                grades.getWeek4(),
                grades.getWeek5(),
                grades.getWeek6(),
                grades.getWeek7(),
                grades.getWeek9(),
                grades.getWeek10(),
                grades.getWeek11(),
                grades.getWeek12(),
                grades.getWeek13(),
                grades.getWeek14(),
                grades.getDiscipline().getDiscipline_id(),
                grades.getStudent().getStudentId());
    }

    @Override
    public int update(Grades grades) {
        return jdbcTemplate.update("update grades " +
                "set endterm=?, exam=?, final_grade=?, midterm=?, week_one=?, week_two=?, week_three=?, week_four=?, week_five=?, week_six=?, week_seven=?, week_nine=?, week_ten=?, week_eleven=?, week_twelve=?, week_thirteen=?, week_fourteen=?",
                grades.getEndterm(),
                grades.getExam(),
                grades.getFinalGrade(),
                grades.getMidterm(),
                grades.getWeek1(),
                grades.getWeek2(),
                grades.getWeek3(),
                grades.getWeek4(),
                grades.getWeek5(),
                grades.getWeek6(),
                grades.getWeek7(),
                grades.getWeek9(),
                grades.getWeek10(),
                grades.getWeek11(),
                grades.getWeek12(),
                grades.getWeek13(),
                grades.getWeek14());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from grades where grade_id=?", id);
    }

    @Override
    public Grades findById(Long student_id, Long discipline_id) throws IndexOutOfBoundsException {
        try {
            return (Grades) jdbcTemplate.query("select * from grades where student_id=? and discipline_id=?", new Object[]{student_id,discipline_id}, new GradesRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Grades();
        }
    }

    @Override
    public List<Grades> findByDiscipline(Long discipline_id) {
        return jdbcTemplate.query("select*from grades where discipline_id=?", new Object[]{discipline_id}, new GradesRowMapper());
    }

    @Override
    public List<Grades> findByStudent(Long studentId) {
        return jdbcTemplate.query("select*from grades where student_id=?", new Object[]{studentId}, new GradesRowMapper());
    }

    @Override
    public List<Grades> findAll() {
        return jdbcTemplate.query("select * from grades", new GradesRowMapper());
    }

}

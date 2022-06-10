package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Grades;
import kz.iitu.itse1908.murzaliev.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradesRSExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Grades grades = new Grades();
        grades.setDiscipline(new Discipline(rs.getLong("discipline_id")));
        grades.setStudent(new Student(rs.getLong("student_id")));
        grades.setGradeId(rs.getLong("grade_id"));
        grades.setEndterm(rs.getDouble("endterm"));
        grades.setExam(rs.getDouble("exam"));
        grades.setFinalGrade(rs.getDouble("final_grade"));
        grades.setMidterm(rs.getDouble("midterm"));
        grades.setWeek1(rs.getDouble("week_one"));
        grades.setWeek2(rs.getDouble("week_two"));
        grades.setWeek3(rs.getDouble("week_three"));
        grades.setWeek4(rs.getDouble("week_four"));
        grades.setWeek5(rs.getDouble("week_five"));
        grades.setWeek6(rs.getDouble("week_six"));
        grades.setWeek7(rs.getDouble("week_seven"));
        grades.setWeek9(rs.getDouble("week_nine"));
        grades.setWeek10(rs.getDouble("week_ten"));
        grades.setWeek11(rs.getDouble("week_eleven"));
        grades.setWeek12(rs.getDouble("week_twelve"));
        grades.setWeek13(rs.getDouble("week_thirteen"));
        grades.setWeek14(rs.getDouble("week_fourteen"));
        return grades;
    }
}

package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRSExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Student student = new Student();
        student.setStudentId(rs.getLong(1));
        student.setGpa(rs.getDouble(2));
        student.setYear(rs.getLong(3));
        student.setDegree(new Degree(rs.getLong(4)));
        student.setDepartment(new Department(rs.getLong(5)));
        student.setSpeciality(new Speciality(rs.getLong(6)));
        student.setUser(new User(rs.getLong(7)));
        return student;
    }
}

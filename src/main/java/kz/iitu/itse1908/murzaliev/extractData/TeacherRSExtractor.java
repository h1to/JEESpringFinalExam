package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRSExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(rs.getLong(1));
        teacher.setFaculty(new Faculty(rs.getLong("faculty_id")));
        teacher.setName(rs.getString("name"));
        teacher.setUser(new User(rs.getLong("user_id")));
        return teacher;
    }
}

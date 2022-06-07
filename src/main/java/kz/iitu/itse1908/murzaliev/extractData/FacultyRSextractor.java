package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyRSextractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Faculty faculty = new Faculty();
        faculty.setFacultyId(rs.getLong(1));
        faculty.setName(rs.getString(2));
        return faculty;
    }
}

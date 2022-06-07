package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DegreeRSExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Degree degree = new Degree();
        degree.setDegreeId(rs.getLong(1));
        degree.setName(rs.getString(2));
        return degree;
    }
}

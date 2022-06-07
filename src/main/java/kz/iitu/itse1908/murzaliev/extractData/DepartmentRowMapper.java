package kz.iitu.itse1908.murzaliev.extractData;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        DepartmentRSExtractor extractor = new DepartmentRSExtractor();
        return extractor.extractData(rs);
    }
}

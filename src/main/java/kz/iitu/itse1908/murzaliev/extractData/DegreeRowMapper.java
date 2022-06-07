package kz.iitu.itse1908.murzaliev.extractData;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DegreeRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        DegreeRSExtractor extractor = new DegreeRSExtractor();
        return extractor.extractData(rs);
    }
}

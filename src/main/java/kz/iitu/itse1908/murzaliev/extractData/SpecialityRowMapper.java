package kz.iitu.itse1908.murzaliev.extractData;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SpecialityRSExtractor extractor = new SpecialityRSExtractor();
        return extractor.extractData(rs);
    }
}

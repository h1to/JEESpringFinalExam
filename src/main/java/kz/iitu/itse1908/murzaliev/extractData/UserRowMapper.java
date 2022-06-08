package kz.iitu.itse1908.murzaliev.extractData;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserRSExtractor extractor = new UserRSExtractor();
        return extractor.extractData(rs);
    }
}

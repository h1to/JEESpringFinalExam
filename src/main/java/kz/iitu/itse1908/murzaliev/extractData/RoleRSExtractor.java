package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRSExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Role role = new Role();
        role.setRoleId(rs.getLong(1));
        role.setName(rs.getString(2));
        return role;
    }
}

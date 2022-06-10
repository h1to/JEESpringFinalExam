package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRSExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user = new User();
        user.setUserId(rs.getLong(1));
        user.setRole(new Role(rs.getLong(2)));
        user.setEmail(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setBlock(rs.getBoolean(5));
        user.setProviderFromDB(rs.getString(6));
        return user;
    }
}

package kz.iitu.itse1908.murzaliev.extractData;

import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.entity.Speciality;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.FacultyRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityRSExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Speciality speciality = new Speciality();
        speciality.setSpecialityId(rs.getLong(1));
        speciality.setName(rs.getString(2));
        speciality.setFaculty(new Faculty(rs.getLong(3)));
        return speciality;
    }
}

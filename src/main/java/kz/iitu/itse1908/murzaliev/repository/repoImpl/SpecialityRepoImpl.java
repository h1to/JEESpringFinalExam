package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Speciality;
import kz.iitu.itse1908.murzaliev.extractData.SpecialityRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialityRepoImpl implements SpecialityRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecialityRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Speciality speciality) {
        return jdbcTemplate.update("insert into speciality (name,faculty_id) values (?,?)", speciality.getName(), speciality.getFaculty().getFacultyId());
    }

    @Override
    public int update(Speciality speciality) {
        return jdbcTemplate.update("update speciality set name=?, faculty_id=? where speciality_id=?", speciality.getName(), speciality.getFaculty().getFacultyId(), speciality.getSpecialityId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from speciality where speciality_is=?", id);
    }

    @Override
    public Speciality findById(Long id) throws IndexOutOfBoundsException {
        try {
            return (Speciality) jdbcTemplate.query("select * from speciality where speciality_id=?", new Object[]{id}, new SpecialityRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Speciality();
        }
    }

    @Override
    public List<Speciality> findAll() {
        return jdbcTemplate.query("select * from speciality", new SpecialityRowMapper());
    }
}

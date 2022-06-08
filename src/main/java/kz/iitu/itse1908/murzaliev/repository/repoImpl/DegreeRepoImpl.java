package kz.iitu.itse1908.murzaliev.repository.repoImpl;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.extractData.DegreeRowMapper;
import kz.iitu.itse1908.murzaliev.repository.repoInterface.DegreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Repository
public class DegreeRepoImpl implements DegreeRepo {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DegreeRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Degree degree) {
        return jdbcTemplate.update("insert into DEGREE (name) values (?)", degree.getName());
    }

    @Override
    public int update(Degree degree) {
        return jdbcTemplate.update("update DEGREE set name = ? where degree_id = ? ", degree.getName(), degree.getDegreeId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from degree where degree_id=?", id);
    }

    @Override
    public Degree findById(Long id) throws IndexOutOfBoundsException {
        try {
            return (Degree)jdbcTemplate.query(
                    "select * from degree where degree_id=?",
                    new Object[] {id},
                    new DegreeRowMapper()).get(0);
        } catch (Exception e) {
            System.out.println(e);
            return new Degree();
        }

    }

    @Override
    public List<Degree> findAll() {
        return jdbcTemplate.query(
                "select * from degree",
                new DegreeRowMapper());
    }
}

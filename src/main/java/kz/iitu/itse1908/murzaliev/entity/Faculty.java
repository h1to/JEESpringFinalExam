package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Faculty {

    @Id
    @Column(name = "faculty_id", nullable = false, insertable = false, updatable = false)
    private Long facultyId;

    @Column(name = "name", nullable = false)
    private String name;
}

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
public class Department {

    @Id
    @Column(name = "department_id", nullable = false, insertable = false, updatable = false)
    private Long departmentId;

    @Column(name = "name", nullable = false)
    private String name;
}

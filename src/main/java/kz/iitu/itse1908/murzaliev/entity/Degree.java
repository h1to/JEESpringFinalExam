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
public class Degree {
    @Id
    @Column(name = "degree_id", nullable = false, insertable = false, updatable = false)
    private Long degreeId;

    @Column(name = "name", nullable = false)
    private String name;
}

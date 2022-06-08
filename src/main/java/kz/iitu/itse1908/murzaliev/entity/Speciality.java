package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@DependsOn("faculty")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Speciality {

    @Id
    @Column(name = "speciality_id", nullable = false, insertable = false, updatable = false)
    private Long specialityId;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Autowired
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Speciality(Long specialityId) {
        this.specialityId = specialityId;
    }
}

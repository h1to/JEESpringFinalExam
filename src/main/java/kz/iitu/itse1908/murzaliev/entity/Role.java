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
public class Role {
    @Id
    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Long roleId;

    @Column(name = "name", nullable = false)
    private String name;

    public Role(Long roleId) {
        this.roleId = roleId;
    }


}

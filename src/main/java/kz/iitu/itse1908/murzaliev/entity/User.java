package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {

    @Id
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NonNull
    @JoinColumn(name = "role_id")
    @OneToOne
    private Role role;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "block")
    private Boolean block;

    public User(@NonNull Role role, @NonNull String email, @NonNull String password, @NonNull Boolean block) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.block = block;
    }

    @Autowired
    public void setRole(Role role) {
        this.role = role;
    }
}

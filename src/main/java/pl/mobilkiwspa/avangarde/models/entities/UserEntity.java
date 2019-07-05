package pl.mobilkiwspa.avangarde.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class UserEntity {
    private @Id @GeneratedValue int id;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private @JsonIgnore String password;
    @Column(name="is_admin")
    private @GeneratedValue boolean isAdmin;

    /*@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) //lazy i eager
            List<BookingEntity> bookings;*/
}

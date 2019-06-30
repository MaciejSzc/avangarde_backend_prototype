package pl.mobilkiwspa.avangarde.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {

    private @Id @GeneratedValue int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String description;
    @Column(name = "img_url")
    private String imgUrl;

   /* @OneToMany(mappedBy = "employee", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) //lazy i eager
            List<BookingEntity> bookings;*/

}

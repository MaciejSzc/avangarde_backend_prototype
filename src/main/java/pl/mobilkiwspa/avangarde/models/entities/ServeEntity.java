package pl.mobilkiwspa.avangarde.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="serve")
@Data
public class ServeEntity {
    private @Id @GeneratedValue int id;
    private String name;
    private String price;
    private String time;

    /*@OneToMany(mappedBy = "serve", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) //lazy i eager
            List<BookingEntity> bookings;*/
}

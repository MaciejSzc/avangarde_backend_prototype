package pl.mobilkiwspa.avangarde.models.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="booking")
@Data
public class BookingEntity {
    private @Id @GeneratedValue int id;
    private Date date;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "serve_id")
    private ServeEntity serve;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}


package pl.mobilkiwspa.avangarde.models.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="day")
@Data
public class DayEntity {
    private @Id @GeneratedValue int id;
    private String name;
    private @Column(name= "is_available") boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;



}

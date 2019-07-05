package pl.mobilkiwspa.avangarde.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hour")
@Data
public class HourEntity {
    private @Id @GeneratedValue int id;

    private boolean ten;
    private boolean eleven;
    private boolean twelve;
    private boolean thirteen;
    private boolean fourteen;
    private boolean fifteen;
    private boolean sixteen;
    private boolean seventeen;
    private boolean eighteen;


    @OneToOne
    @JoinColumn(name = "day_id")
    private DayEntity day;
}

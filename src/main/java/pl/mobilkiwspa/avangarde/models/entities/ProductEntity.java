package pl.mobilkiwspa.avangarde.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
@Data
public class ProductEntity {
    private @Id @GeneratedValue int id;
    private String name;
    private int count;
}

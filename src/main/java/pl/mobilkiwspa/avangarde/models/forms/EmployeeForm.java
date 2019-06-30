package pl.mobilkiwspa.avangarde.models.forms;

import lombok.Data;

@Data
public class EmployeeForm {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String description;
    private String imgUrl;
}

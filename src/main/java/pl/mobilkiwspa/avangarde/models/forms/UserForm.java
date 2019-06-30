package pl.mobilkiwspa.avangarde.models.forms;

import lombok.Data;

@Data
public class UserForm {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String password;
}

package pl.mobilkiwspa.avangarde.models.forms;

import lombok.Data;

@Data
public class ServeForm {
    private int id;
    private String name;
    private String summary;
    private String price;
    private String time;
}

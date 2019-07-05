package pl.mobilkiwspa.avangarde.models.forms;

import lombok.Data;

import java.util.Date;

@Data
public class BookingForm {
    private int employee_id;
    private int serve_id;
    private int user_form;
    private String date;
}

package pl.mobilkiwspa.avangarde.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mobilkiwspa.avangarde.models.services.EmployeeService;

@Controller
public class BookingController {

    final EmployeeService employeeService;

    public BookingController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/booking")
    public String booking(Model model){
        model.addAttribute("stylists", employeeService.getAll());
        return "booking";
    }

    @GetMapping("/booking/{id}")
    public String pickDate(@PathVariable("id") int id, Model model){

        return "booking_date";
    }


}

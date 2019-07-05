package pl.mobilkiwspa.avangarde.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mobilkiwspa.avangarde.models.services.EmployeeService;
import pl.mobilkiwspa.avangarde.models.services.ServeService;
import pl.mobilkiwspa.avangarde.models.services.TimeService;

@Controller
public class BookingController {

    final EmployeeService employeeService;
    final TimeService timeService;
    final ServeService serveService;

    public BookingController(EmployeeService employeeService, TimeService timeService, ServeService serveService){
        this.employeeService = employeeService;
        this.timeService = timeService;
        this.serveService = serveService;
    }

    @GetMapping("/booking")
    public String booking(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "booking_stylist";
    }

    @GetMapping("/booking/{id}")
    public String pickDate(@PathVariable("id") int id, Model model){
        model.addAttribute("stylist", employeeService.getEmployeeById(id));
        model.addAttribute("days", employeeService.showAvailableDaysForCurrentEmployee(id));

        return "booking_stylist_id";
    }

    @GetMapping("/booking/{id}/{dayId}")
    public String pickHour(@PathVariable("id") int id, @PathVariable("dayId") int dayId, Model model){
    //model.addAttribute("hours", timeService.showAvailableHoursForCurrentDay(dayId));
        model.addAttribute("day", timeService.showAvailableHoursForCurrentDay(dayId));
        model.addAttribute("stylist", employeeService.getEmployeeById(id));

        return "booking_stylist_id_hour";
    }

//    @GetMapping("/booking/{id}/{dayId}/{hourId}")
//    public String pickServe(@PathVariable("id") int id, @PathVariable("hourId") int hourId, @PathVariable("serveId") int serveId ,Model model){
//        model.addAttribute("serves", serveService.)
//    }




}

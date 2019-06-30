package pl.mobilkiwspa.avangarde.controllers.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mobilkiwspa.avangarde.models.forms.EmployeeForm;
import pl.mobilkiwspa.avangarde.models.forms.ProductForm;
import pl.mobilkiwspa.avangarde.models.forms.ServeForm;
import pl.mobilkiwspa.avangarde.models.services.*;

@Controller
public class AdminMainController {

    final BookingService bookingService;
    final EmployeeService employeeService;
    final ServeService serveService;
    final ProductService productService;
    final UserService userService;

    public AdminMainController(BookingService bookingService, EmployeeService employeeService, ServeService serveService, ProductService productService, UserService userService){
        this.bookingService = bookingService;
        this.employeeService = employeeService;
        this.serveService = serveService;
        this.productService = productService;
        this.userService = userService;

    }
//--------------------Employee
    @GetMapping("/admin/employee")
    public String adminEmployee(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "admin_employee";
    }

    @GetMapping("/admin/employee/add")
    public String adminEmployeAdd(Model model){
        model.addAttribute("employee", new EmployeeForm());
        return "admin_employee_add";
    }

    @PostMapping("/admin/employee/add")
    public String adminEmployeAddPost(@ModelAttribute("employee") EmployeeForm employeeForm, Model model){
        employeeService.addEmployee(employeeForm);
        return "redirect:/admin_employee";
    }

   /* @GetMapping("/update/employee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", new EmployeeForm());
        return "admin_employee_add";
    }*/
//--------------------Booking
    @GetMapping("/admin/booking")
    public String adminBooking(Model model){
        model.addAttribute("bookings", bookingService.getAll());
        return "admin_booking";
    }


//--------------------Serve
    @GetMapping("/admin/serve")
    public String adminServe(Model model){
        model.addAttribute("serves", serveService.getAll());
        return "admin_serve";
    }

    @GetMapping("/admin/serve/add")
    public String adminServeAdd(Model model){
        model.addAttribute("serve", new ServeForm());
        return "admin_serve_add";
    }

    @PostMapping("/admin/serve/add")
    public String adminServeAddPost(@ModelAttribute("serve")ServeForm serveForm, Model model){
        serveService.addServe(serveForm);
        return "redirect:/admin_serve";
    }
//--------------------Warehouse
    @GetMapping("/admin/product")
    public String adminProduct(Model model){
        model.addAttribute("products", productService.getAll());
        return "admin_product";
    }

    @GetMapping("/admin/product/add")
    public String adminProductAdd(Model model){
        model.addAttribute("product", new ProductForm());
        return "admin_product_add";
    }

    @PostMapping("/admin/product/add")
    public String adminProductAddPost(@ModelAttribute("employee") ProductForm productForm, Model model){
        productService.addProduct(productForm);
        return "redirect:/admin_product";
    }

}

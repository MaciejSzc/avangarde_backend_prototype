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
    //--------------------Main
    @GetMapping("/")
    public String avangarde(){return "avangarde";}

    @GetMapping("/admin")
        public String adminMain(){
        return "admin";
    }
//--------------------Employee
    @GetMapping("/admin/employee")
    public String adminEmployee(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "admin_employee";
    }

    @GetMapping("/admin/employee/add")
    public String adminEmployeAdd(Model model){
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee_add";
    }

    @PostMapping("/admin/employee/add")
    public String adminEmployeAddPost(@ModelAttribute EmployeeForm employeeForm, Model model){
        employeeService.addEmployee(employeeForm);
        return "redirect:/admin/employee";
    }

    @GetMapping("admin/employee/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employeeForm", new EmployeeForm());
        model.addAttribute("employee", employeeService.getEmployeeById(id));

        return "employee_update";
    }

    @PostMapping("admin/employee/update/{id}")
    public String udatePEmployee(@ModelAttribute EmployeeForm employeeForm, @PathVariable("id") int id, Model model) {

        employeeService.update(id, employeeForm);

        return "redirect:/admin/employee";
    }


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
        model.addAttribute("serveForm", new ServeForm());
        return "serve_add";
    }

    @PostMapping("/admin/serve/add")
    public String adminServeAddPost(@ModelAttribute ServeForm serveForm, Model model){
        serveService.addServe(serveForm);
        return "redirect:/admin/serve";
    }

    @GetMapping("admin/serve/update/{id}")
    public String updateServe(@PathVariable("id") int id, Model model) {
        model.addAttribute("serveForm", new ServeForm());
        model.addAttribute("serve", serveService.getServeById(id));

        return "serve_update";
    }

    @PostMapping("admin/serve/update/{id}")
    public String udatePServe(@ModelAttribute ServeForm serveForm, @PathVariable("id") int id, Model model) {

        serveService.update(id, serveForm);

        return "redirect:/admin/serve";
    }


//--------------------Warehouse
    @GetMapping("/admin/product")
    public String adminProduct(Model model){
        model.addAttribute("products", productService.getAll());
        return "admin_product";
    }

    @GetMapping("/admin/product/add")
    public String adminProductAdd(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product_add";
    }

    @PostMapping("/admin/product/add")
    public String adminProductAddPost(@ModelAttribute ProductForm productForm, Model model){
        productService.addProduct(productForm);
        return "redirect:/admin/product";
    }

    @GetMapping("admin/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("product", productService.getProductById(id));

        return "product_update";
    }

    @PostMapping("admin/product/update/{id}")
    public String updatePProduct(@ModelAttribute ProductForm productForm, @PathVariable("id") int id, Model model) {

        productService.update(id, productForm);

        return "redirect:/admin/product";
    }

}

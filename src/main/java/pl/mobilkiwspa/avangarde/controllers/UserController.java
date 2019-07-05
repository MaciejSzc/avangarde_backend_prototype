package pl.mobilkiwspa.avangarde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mobilkiwspa.avangarde.models.forms.UserForm;
import pl.mobilkiwspa.avangarde.models.services.UserService;
import pl.mobilkiwspa.avangarde.models.services.UserSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserSession userSession;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserForm userForm, Model model) {
        if (!userService.login(userForm)) {
            model.addAttribute("info", "Login lub haslo nieprawidlowe");
            return "login";
        }
        if(userService.getLoginUser().isPresent() && !userService.getLoginUser().get().isAdmin()){
            return "redirect:/booking";
        }
        return "redirect:/admin";
    }


     @GetMapping("/registration")
    public String registration(Model model){
            model.addAttribute("userForm", new UserForm());
            return "registration";
        }

        @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm")UserForm userForm, Model model){
            if(!userService.checkIfUserWithThatEmailExist(userForm.getEmail())){
                model.addAttribute("info", "Użytkownik o podanym email już istnieje");
                return "registration";
            }
            userService.registerNewUser(userForm);
            model.addAttribute("info", "Konto utworzone. Możesz się zalogować.");
            return "registration";
        }
}

package pl.mobilkiwspa.avangarde.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mobilkiwspa.avangarde.models.entities.UserEntity;
import pl.mobilkiwspa.avangarde.models.forms.UserForm;
import pl.mobilkiwspa.avangarde.models.services.UserService;

@RestController
@RequestMapping("/api")
public class UserControllerApi {

    final UserService userService;

    @Autowired
    public UserControllerApi(UserService userService){
        this.userService = userService;

    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") int id){
        UserEntity user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }


    @DeleteMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity softDeleteUserById(@PathVariable("id") int id){
        userService.softDeleteUserById(id);
        return ResponseEntity.ok("deleted " + id);
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity saveUser(@RequestBody UserForm userForm){
        if(!userService.checkIfUserWithThatEmailExist(userForm.getEmail())){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username is taken");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}

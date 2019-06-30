package pl.mobilkiwspa.avangarde.api;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import pl.mobilkiwspa.avangarde.models.forms.UserForm;
import pl.mobilkiwspa.avangarde.models.services.UserService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestController
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerApiTest {

    @Mock
    UserService userService;


    @InjectMocks
    UserControllerApi userControllerApi;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveUser() throws Exception {//shouldAddUser

        //given
        UserForm userForm = new UserForm();
        userForm.setPassword("test");
        userForm.setEmail("test");
        userForm.setEmail("name");
        userForm.setEmail("surname");
        userForm.setEmail("telephone");
        //trzeba equalsa i hasha w obiektach zeby dzialalo

        //when
        Mockito.when(userService.registerNewUser(userForm)).thenReturn(true);

        //then
        mockMvc.perform(post("/api/user")
                .content(getGson().toJson(userForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }


    public Gson getGson(){
        return new Gson();
    }

    @Test
    void deleteUser() throws Exception {
        UserForm userForm = new UserForm();
        int x = anyInt();
        userForm.setId(x);
//when //tak mockujesz voida
        doAnswer(s -> null).when(userService).getUserById(x);


//then
        //todo Make documentation for api-key
        mockMvc.perform(delete("/api/user/" + x)
                .header("api-key", "ddfsgggffdfgssfg"))
                .andExpect(status().isOk())
                .andExpect(content().string(matches("Deleted + ")));
    }
}


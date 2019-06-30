package pl.mobilkiwspa.avangarde.models.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mobilkiwspa.avangarde.models.entities.UserEntity;
import pl.mobilkiwspa.avangarde.models.forms.UserForm;
import pl.mobilkiwspa.avangarde.models.repositories.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class UserServiceTest {


    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoderService passwordEncoderService;

    @Mock
            UserSession userSession;

    @InjectMocks
            UserService userService;


    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void login() {
        //given
        String testPassHash = "$2a$10$vOTTj1O7fjCKlAhV8CRjY./IPBdyUjMm3FlTay.3TqDPwqUY6u9PO";


        UserForm userForm = new UserForm();
        userForm.setEmail("test");
        userForm.setPassword("test");

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test");
        userEntity.setPassword(testPassHash);

        //when
        Mockito.when(userRepository.getUserByEmail("test")).thenReturn(userEntity);

        //then
        Assertions.assertTrue(userService.login(userForm));
    }

}

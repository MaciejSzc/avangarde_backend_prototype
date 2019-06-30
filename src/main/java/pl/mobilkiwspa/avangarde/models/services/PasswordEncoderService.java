package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
    @Bean
    public BCryptPasswordEncoder getBCryrpt() {
        return new BCryptPasswordEncoder();
    }
}
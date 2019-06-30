package pl.mobilkiwspa.avangarde.models.services;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
//@SessionScope
public class UserSession {
    private  int userId;
    private  boolean isLogin;
}
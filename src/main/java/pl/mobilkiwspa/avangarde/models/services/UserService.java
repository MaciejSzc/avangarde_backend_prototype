package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.UserEntity;
import pl.mobilkiwspa.avangarde.models.forms.UserForm;
import pl.mobilkiwspa.avangarde.models.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSession userSession;
    @Autowired
    PasswordEncoderService passwordEncoderService;




    public boolean login(UserForm userForm){
        UserEntity user = userRepository.getUserByEmail(userForm.getEmail());

        if(user != null && passwordEncoderService.getBCryrpt().matches(userForm.getPassword(), user.getPassword())){
            userSession.setLogin(true);
            userSession.setUserId(user.getId());
            return true;
        }

        return false;
    }

    /*public void logout(){
        userSession.setLogin(false);
    }
*/



    public Optional<UserEntity> getLoginUser(){

        return userRepository.findById(userSession.getUserId());
    }

    public Iterable<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(int id){
        return userRepository.getUserById(id);

    }

    public boolean checkIfUserWithThatEmailExist(String email){
        if(userRepository.checkIfUserWithThatEmailExist(email)){
            return false;
        }

        return true;
    }

    public boolean registerNewUser(UserForm userForm){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userForm.getName());
        userEntity.setSurname(userForm.getSurname());
        userEntity.setEmail(userForm.getEmail());
        userEntity.setPassword(passwordEncoderService.getBCryrpt().encode(userForm.getPassword()));
        userEntity.setTelephone(userForm.getTelephone());

        userRepository.save(userEntity);
        return true;
    }

    @Transactional
    public void softDeleteUserById(int userId){
        userRepository.setIsDeletedAsTrue(userId);
    }
}

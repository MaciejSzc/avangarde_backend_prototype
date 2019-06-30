package pl.mobilkiwspa.avangarde.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mobilkiwspa.avangarde.models.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `email` = ?1 AND `password` = ?2")
    Optional<UserEntity> getUser(String email, String password);

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `email` = ?1")
    UserEntity getUserByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM `user` WHERE `id` = ?1")
    UserEntity getUserById(int id);

    @Query(nativeQuery = true, value = "UPDATE  `user` SET `is_delete` = 1 WHERE `id` = ?1")
    @Modifying
    void setIsDeletedAsTrue(int id);

    @Query(nativeQuery = true, value = "SELECT CASE WHEN COUNT(`id`) > 0 THEN 'true' ELSE 'false' END FROM `user` WHERE email = ?1")
    boolean checkIfUserWithThatEmailExist(String email);



}

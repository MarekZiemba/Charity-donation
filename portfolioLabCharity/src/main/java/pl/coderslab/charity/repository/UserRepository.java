package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //with Roles
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    User findByActivationToken(String token);

    Optional<User> findByResetToken(String resetToken);

    List<User> findByUsernameContains(String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    List<User> findUserByEmailContains(String email);

    List<User> findAll();

    Optional<User> findById(Long id);

    List<User> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    List<User> findByRoles(@Param("roles") Role roles);

    List<User> findByRolesName(String name);

    User findById(Class<User> userClass, Long id);

}

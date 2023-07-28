package pl.coderslab.charity.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "{not.empty.error}")

    @Column(nullable = false, unique = true, length = 60)
    private String username;

//    @NotBlank(message = "{not.empty.error}")
//    @Size(min = 2, message = "{too.short.error}")
    private String password;

    private String newPassword;

    private String confirmPassword;

    @Email
    private String email;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String firstName;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String lastName;

    private LocalDate dateOfBirth;

    private String profilePhotoUrl;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER) // ma zadzialac LAZY
    private Set<Role> roles;

    public void removeRoles() {
        for (Role role: roles) {
            role.getUsers();
        }
        roles.clear();
    }

}

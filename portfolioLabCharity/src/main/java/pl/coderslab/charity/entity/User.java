package pl.coderslab.charity.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import java.util.Date;
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
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    //    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
    //    message = "{password.invalid.error}")
    private String password;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String firstName;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String lastName;

    @NotNull
    @Timestamp
    private Date dateOfBirth;

    private String profilePhotoUrl;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

//    public User(String email, String password, String firstName, String lastName) {
//        this.email = email;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public void removeRoles() {
        for (Role role: roles) {
            role.getUsers();
        }
        roles.clear();
    }

}

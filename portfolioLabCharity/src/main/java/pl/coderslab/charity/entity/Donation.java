package pl.coderslab.charity.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "donations")
@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 1)
    private int quantity;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String street;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String city;

    @NotBlank(message = "{not.empty.error}")
    @Pattern(regexp = "^\\d{2}-\\d{3}$")
    private String zipCode;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 9, message = "{too.short.error}")
    private String phone;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    @Size(max = 2000)
    private String pickUpComment;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    public void removeAllCategories() {
        for (Category category : categories) {
            category.getDonations().remove(this);
        }
        categories.clear();
    }
}

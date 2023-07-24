package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "institutions")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Size(max = 300)
    private String description;

    @OneToMany(mappedBy = "institution")
    @ToString.Exclude
    private Set<Donation> donations;

    public void removeAllDonations() {
        for (Donation donation : donations) {
            donation.setInstitution(null);
        }
        donations.clear();
    }

}

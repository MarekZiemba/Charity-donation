package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Set<Donation> donations;

    public void removeAllDonations() {
        for (Donation donation : donations) {
            donation.setCategory(null);
        }
        donations.clear();
    }

}

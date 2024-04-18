package za.co.favourokwara.investmentapi.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.favourokwara.core.model.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "investors")
@AttributeOverride(name = "id", column = @Column(name = "investor_id", nullable = false))
public class Investor extends BaseEntity<Long> {

    @Column(name = "national_id", unique = true, nullable = false, length = 13)
    private String nationalId;

    @Column(name = "first_name", length = 40)
    private String firstName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy= "id.investor", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<InvestorProduct> investorProducts = new HashSet<>();
    
    // region equals & hash code
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (this == obj || getClass() != obj.getClass())
            return false;

        Investor investor = (Investor) obj;
        return Objects.equals(nationalId, investor.nationalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId);
    }
}

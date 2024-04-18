package za.co.favourokwara.investmentapi.model.entities.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.favourokwara.investmentapi.model.entities.Investor;
import za.co.favourokwara.investmentapi.model.entities.Product;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InvestorProductId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return true;

        InvestorProductId id = (InvestorProductId) obj;
        return Objects.equals(investor, id.investor) && Objects.equals(product, id.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(investor, product);
    }
}

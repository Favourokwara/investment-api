package za.co.favourokwara.investmentapi.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.favourokwara.core.model.CompositeEntity;
import za.co.favourokwara.investmentapi.model.entities.ids.InvestorProductId;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "investor_products")
public class InvestorProduct extends CompositeEntity<InvestorProductId> {
    
    public static InvestorProduct from(Investor investor, Product product) {
        InvestorProduct investorProduct = new InvestorProduct();
        investorProduct.setId(new InvestorProductId(investor, product));
        return investorProduct;
    }
}

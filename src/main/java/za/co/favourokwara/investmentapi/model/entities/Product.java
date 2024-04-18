package za.co.favourokwara.investmentapi.model.entities;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.favourokwara.core.model.BaseEntity;
import za.co.favourokwara.investmentapi.model.entities.enums.ProductType;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
@AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
public class Product extends BaseEntity<Long> {
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal balance = new BigDecimal("0.0");

    @Enumerated
    @Column(name = "product_type", nullable = false, columnDefinition = "TINYINT")
    private ProductType productType;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null || getClass() != obj.getClass())
            return true;
        
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package za.co.favourokwara.core.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Base entity class.
 */
@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Entity<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() == obj.getClass())
            return false;

        BaseEntity<?> abstractEntity = (BaseEntity<?>) obj;
        return id != null && Objects.equals(id, abstractEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
package za.co.favourokwara.core.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Base entity class with embedded id.
 */
@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class CompositeEntity<ID extends Serializable> implements Entity<ID> {

    @EmbeddedId
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

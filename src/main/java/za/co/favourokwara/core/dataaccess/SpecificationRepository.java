package za.co.favourokwara.core.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SpecificationRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}

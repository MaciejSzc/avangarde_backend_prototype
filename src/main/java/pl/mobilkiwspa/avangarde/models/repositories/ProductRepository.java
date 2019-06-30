package pl.mobilkiwspa.avangarde.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mobilkiwspa.avangarde.models.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}

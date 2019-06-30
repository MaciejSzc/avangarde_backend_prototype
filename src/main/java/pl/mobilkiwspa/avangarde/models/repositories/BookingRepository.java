package pl.mobilkiwspa.avangarde.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mobilkiwspa.avangarde.models.entities.BookingEntity;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

}

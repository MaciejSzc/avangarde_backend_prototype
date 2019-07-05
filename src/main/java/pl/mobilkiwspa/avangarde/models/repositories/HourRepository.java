package pl.mobilkiwspa.avangarde.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mobilkiwspa.avangarde.models.entities.HourEntity;

import java.util.List;

@Repository
public interface HourRepository extends CrudRepository<HourEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM `hour` WHERE `day_id` = ?1")
    List<HourEntity> getHours(int dayId);
}

package pl.mobilkiwspa.avangarde.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mobilkiwspa.avangarde.models.entities.DayEntity;

import java.util.List;
@Repository
public interface DayRepository extends CrudRepository<DayEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM `day` WHERE `employee_id` = ?1")
    List<DayEntity> getDays(int employeeId);
}

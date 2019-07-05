package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.DayEntity;
import pl.mobilkiwspa.avangarde.models.entities.HourEntity;
import pl.mobilkiwspa.avangarde.models.repositories.DayRepository;
import pl.mobilkiwspa.avangarde.models.repositories.HourRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    @Autowired
    DayRepository dayRepository;
    @Autowired
    HourRepository hourRepository;

    public List<DayEntity> dayEntities(int employeeId){
        return dayRepository.getDays(employeeId);
    }




    public DayEntity showAvailableHoursForCurrentDay(int dayId){

        Optional<DayEntity> dayEntity = dayRepository.findById(dayId);






        return dayEntity.get();
    }
 }

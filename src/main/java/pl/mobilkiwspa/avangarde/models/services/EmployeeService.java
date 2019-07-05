package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.DayEntity;
import pl.mobilkiwspa.avangarde.models.entities.EmployeeEntity;
import pl.mobilkiwspa.avangarde.models.entities.HourEntity;
import pl.mobilkiwspa.avangarde.models.forms.EmployeeForm;
import pl.mobilkiwspa.avangarde.models.repositories.DayRepository;
import pl.mobilkiwspa.avangarde.models.repositories.EmployeeRepository;
import pl.mobilkiwspa.avangarde.models.repositories.HourRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    HourRepository hourRepository;

    @Autowired
    TimeService timeService;

    public Iterable<EmployeeEntity> getAll(){
        return employeeRepository.findAll();
    }



    public void addEmployee(EmployeeForm employeeForm){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(employeeForm.getName());
        employeeEntity.setSurname(employeeForm.getSurname());
        employeeEntity.setTelephone(employeeForm.getTelephone());
        employeeEntity.setEmail(employeeForm.getEmail());
        employeeEntity.setDescription(employeeForm.getDescription());

        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }

    public void update(int id, EmployeeForm employeeForm) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

        if(employeeEntity.isPresent()) {
            employeeEntity.get().setName(employeeForm.getName());
            employeeEntity.get().setSurname(employeeForm.getSurname());
            employeeEntity.get().setEmail(employeeForm.getEmail());
            employeeEntity.get().setTelephone(employeeForm.getTelephone());
            employeeEntity.get().setDescription(employeeForm.getDescription());
            employeeRepository.save(employeeEntity.get());
        }


    }

    public EmployeeEntity getEmployeeById(int id){

        return employeeRepository.findById(id).get();
    }

    public List<DayEntity> showAvailableDaysForCurrentEmployee(int employeeId){
        List<DayEntity> availableDays = new ArrayList<>();
        List<DayEntity> allDays = dayRepository.getDays(employeeId);
        for (DayEntity day: allDays) {

            for (HourEntity hour: hourRepository.getHours(day.getId())
            ) {
                if (hour.isTen() || hour.isEleven() || hour.isTwelve() || hour.isThirteen() || hour.isFourteen() ||
                        hour.isFifteen() || hour.isSixteen() || hour.isSeventeen() || hour.isEighteen()){
                    availableDays.add(day);
                }

            }
        }

        return availableDays;
    }






}



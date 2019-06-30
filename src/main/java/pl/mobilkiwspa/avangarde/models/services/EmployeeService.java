package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.EmployeeEntity;
import pl.mobilkiwspa.avangarde.models.forms.EmployeeForm;
import pl.mobilkiwspa.avangarde.models.repositories.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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

    public void updateEmployee(int id, EmployeeForm employeeForm) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);


    }


}


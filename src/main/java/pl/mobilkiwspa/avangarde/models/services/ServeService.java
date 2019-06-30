package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.EmployeeEntity;
import pl.mobilkiwspa.avangarde.models.entities.ServeEntity;
import pl.mobilkiwspa.avangarde.models.forms.ServeForm;
import pl.mobilkiwspa.avangarde.models.repositories.ServeRepository;

@Service
public class ServeService {
    @Autowired
    ServeRepository serveRepository;

    public Iterable<ServeEntity> getAll(){
        return serveRepository.findAll();
    }

    public void addServe(ServeForm serveForm){
        ServeEntity serveEntity = new ServeEntity();

        serveEntity.setName(serveForm.getName());
        serveEntity.setPrice(serveForm.getPrice());
        serveEntity.setSummary(serveForm.getSummary());
        serveEntity.setTime(serveForm.getTime());

        serveRepository.save(serveEntity);
    }
}

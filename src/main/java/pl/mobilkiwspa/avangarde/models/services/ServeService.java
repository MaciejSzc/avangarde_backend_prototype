package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.EmployeeEntity;
import pl.mobilkiwspa.avangarde.models.entities.ServeEntity;
import pl.mobilkiwspa.avangarde.models.forms.ServeForm;
import pl.mobilkiwspa.avangarde.models.repositories.ServeRepository;

import java.util.Optional;

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
        serveEntity.setTime(serveForm.getTime());

        serveRepository.save(serveEntity);
    }

    public void update(int id, ServeForm serveForm){
        Optional<ServeEntity> serveEntity = serveRepository.findById(id);

        if(serveEntity.isPresent()){
            serveEntity.get().setName(serveForm.getName());
            serveEntity.get().setPrice(serveForm.getPrice());
            serveEntity.get().setTime(serveForm.getTime());

            serveRepository.save(serveEntity.get());
        }
    }

    public ServeEntity getServeById(int id){

        return serveRepository.findById(id).get();
    }
}

package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.BookingEntity;
import pl.mobilkiwspa.avangarde.models.entities.EmployeeEntity;
import pl.mobilkiwspa.avangarde.models.forms.BookingForm;
import pl.mobilkiwspa.avangarde.models.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Iterable<BookingEntity> getAll() {
        return bookingRepository.findAll();
    }

    public void addBooking(BookingForm bookingForm){
        BookingEntity bookingEntity = new BookingEntity();


    }


}

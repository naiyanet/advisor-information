
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.Appointment;
import th.co.geniustree.intenship.advisor.repo.AppointmentRepo;

/**
 *
 * @author User
 */
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentRepo appointmentRepo;
    
    @RequestMapping(value = "/getappointment",method = RequestMethod.GET)
    public Page<Appointment> getAppointment (Pageable pageable){
        return appointmentRepo.findAll(pageable);
    }
    
    @RequestMapping (value = "/saveappointment",method = RequestMethod.POST)
    public void saveAppointment(@Validated @RequestBody Appointment appointment){
        appointmentRepo.save(appointment);
    }
    
     @RequestMapping(value = "/deleteappointment",method = RequestMethod.POST)
    public void deleteAppointment(@RequestBody Appointment appointment){
        appointmentRepo.delete(appointment.getId());
    }
}

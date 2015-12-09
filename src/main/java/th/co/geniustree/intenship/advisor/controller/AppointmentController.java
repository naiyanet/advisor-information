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
import th.co.geniustree.intenship.advisor.model.SearchData;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.AppointmentRepo;
import th.co.geniustree.intenship.advisor.service.AppointmentSearchService;
import th.co.geniustree.intenship.advisor.service.StudentSearchService;
/**
 *
 * @author User
 */
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private AppointmentSearchService appointmentSearchService;
    @Autowired
    private StudentSearchService studentSearchService;

    
    @RequestMapping(value = "/getappointment",method = RequestMethod.POST)
    public Page<Appointment> getAppointment(@RequestBody SearchData searchData,Pageable pageable){
        String searchBy = searchData.getSearchBy();
        String keyword = searchData.getKeyWord();
        Page<Appointment> appointment = null;
        if ("Teacher".equals(searchBy)){
            appointment = appointmentSearchService.searchNameTeacherAppointment(keyword, pageable);
        }else{
            appointment = appointmentSearchService.searchNameStudentAppointment(keyword, pageable);
        }
        return appointment;
    }
    
    @RequestMapping (value = "/saveappointment",method = RequestMethod.POST)
    public void saveAppointment(@Validated @RequestBody Appointment appointment){
        appointmentRepo.save(appointment);
    }
    
     @RequestMapping(value = "/delappointment",method = RequestMethod.POST)
    public void deleteAppointment(@RequestBody Integer appointment){
        appointmentRepo.delete(appointment);
    }
    
    
    
    @RequestMapping(value = "/getstudentofteacherApp",method = RequestMethod.POST)
    public Page<Student> getStudentOfTeacher(@RequestBody Integer keyword, Pageable pageable){
        Page<Student> students = studentSearchService.searchStudentByTeacher(keyword, pageable);
        return students;
    }
    
    @RequestMapping(value = "/searchStudentInAppoint", method = RequestMethod.POST)
    public Page<Appointment> searchStudent(@RequestBody String keyword, Pageable pageable) {
        return appointmentSearchService.searchNameStudentAppointment(keyword, pageable);
    }
    
    @RequestMapping(value = "/gettotalappointment" ,method = RequestMethod.GET)
    private long getTotalRowAdvisor(){
        return appointmentRepo.count();
    }
}
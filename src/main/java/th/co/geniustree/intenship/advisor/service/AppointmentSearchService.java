/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Appointment;
import th.co.geniustree.intenship.advisor.repo.AppointmentRepo;
import th.co.geniustree.intenship.advisor.spec.AppointmentSpec;

/**
 *
 * @author momo
 */
@Service
public class AppointmentSearchService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    
    public Page<Appointment> searchNameStudentAppointment(String keyword,Pageable pageable){
        Specifications<Appointment> specifications = Specifications.where(AppointmentSpec.nameLike("%"+keyword+"%"));
        return appointmentRepo.findAll(specifications, pageable);
    }
    
    public Page<Appointment>searchNameTeacherAppointment(String keyword,Pageable pageable){
        Specifications<Appointment>specifications = Specifications.where(AppointmentSpec.nameTeacherLike("%"+keyword+"%"));
        return appointmentRepo.findAll(specifications, pageable);
    }
}

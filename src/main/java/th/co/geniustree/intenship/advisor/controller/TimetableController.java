/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.Timetable;
import th.co.geniustree.intenship.advisor.repo.TimetableRepo;

/**
 *
 * @author User
 */
@RestController
public class TimetableController {
    @Autowired
    private TimetableRepo timetableRepo;
    
    @RequestMapping(value = "/timetable")
    public Page<Timetable> getTimetable(Pageable pageable){
        return timetableRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savetimetable")
    public void saveTimetable(@Validated @RequestBody Timetable timetable){
        timetableRepo.save(timetable);
    }
    
    @RequestMapping(value = "/deletetimetable")
    public void deleteTimetable(@RequestBody Timetable timetable){
        timetableRepo.delete(timetable.getId());
    }
}

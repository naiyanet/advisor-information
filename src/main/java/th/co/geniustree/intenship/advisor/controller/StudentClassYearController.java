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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.StudentClassYear;
import th.co.geniustree.intenship.advisor.repo.StudentClassYearRepo;

/**
 *
 * @author User
 */
@RestController
public class StudentClassYearController {
    @Autowired
    private StudentClassYearRepo studentClassYearrepo;
    
    @RequestMapping(value = "/getstudentclassyear",method = RequestMethod.GET)
    public Page<StudentClassYear> getStudentClassYear (Pageable pageable){
        return studentClassYearrepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savestudentclassyear",method = RequestMethod.POST)
    public void saveStudentClassYear (@Validated @RequestBody StudentClassYear studentClassYear){
        studentClassYearrepo.save(studentClassYear);
    }
    
    @RequestMapping(value = "/deletestudentclassyear",method = RequestMethod.POST)
    public void deleteStudentClassYear (@RequestBody StudentClassYear studentClassYear){
        studentClassYearrepo.delete(studentClassYear);
    }
}

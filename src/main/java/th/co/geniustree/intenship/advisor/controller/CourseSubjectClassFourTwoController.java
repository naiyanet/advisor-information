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
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassFourTwo;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassOneTwo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassFourTwoRepo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassOneTwoRepo;


/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassFourTwoController {
    
    @Autowired
    private CourseSubjectClassFourTwoRepo classFourTwoRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassfourtermtwo",method = RequestMethod.GET)
    public Page<CourseSubjectClassFourTwo> getCourseSubjectClassOneTwo (Pageable pageable){
        return classFourTwoRepo.findAll(pageable);
    }
    @RequestMapping(value = "/savecoursesubjectclassfourtermtwo",method = RequestMethod.POST)
    public void saveCourseSubjectClassOneTwo(@Validated @RequestBody CourseSubjectClassFourTwo classOneTwo){
        classFourTwoRepo.save(classOneTwo);
    }
    @RequestMapping(value = "/deletecoursesubjectclassfourtermtwo",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOneTwo(@RequestBody CourseSubjectClassFourTwo classOneTwo){
        classFourTwoRepo.delete(classOneTwo);
    }
}

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
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassThree;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassThreeRepo;


/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassThreeController {
    @Autowired
    private CourseSubjectClassThreeRepo courseSubjectClassThreeRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassthree",method = RequestMethod.GET)
    public Page<CourseSubjectClassThree> getCourseSubjectClassThree (Pageable pageable){
        return courseSubjectClassThreeRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savecoursesubjectclassthree",method = RequestMethod.POST)
    public void saveCourseSubjectClassThree(@Validated @RequestBody CourseSubjectClassThree courseClass){
        courseSubjectClassThreeRepo.save(courseClass);
    }
    
    @RequestMapping(value = "/deletecoursesubjectclassthree",method = RequestMethod.POST)
    public void deleteCourseSubjectClassThree(@RequestBody CourseSubjectClassThree courseClass){
        courseSubjectClassThreeRepo.delete(courseClass);
    }
}

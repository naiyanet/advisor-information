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
import th.co.geniustree.intenship.advisor.model.Course;
import th.co.geniustree.intenship.advisor.repo.CourseRepo;

/**
 *
 * @author User
 */
@RestController
public class CourseController {
    @Autowired
    private CourseRepo courseRepo;
    
    @RequestMapping(value = "/getcourse",method = RequestMethod.GET)
    public Page<Course> getCourse(Pageable pageable){
        return courseRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savecourse",method = RequestMethod.POST)
    public void saveCourse(@Validated @RequestBody Course course){
        courseRepo.save(course);
    }
    
    @RequestMapping(value = "/deletecourse",method = RequestMethod.POST)
    public void deleteCourse(@RequestBody Course course){
        courseRepo.delete(course.getId());
    }
}

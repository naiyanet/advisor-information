/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CategoryCourse;
import th.co.geniustree.intenship.advisor.model.Course;
import th.co.geniustree.intenship.advisor.repo.CategoryCourseRepo;

/**
 *
 * @author User
 */
@RestController
public class CategoryCourseController {
    @Autowired
    private CategoryCourseRepo categoryCourseRepo;
    
    @RequestMapping(value = "/getcategorycourse",method = RequestMethod.GET)
    public Page<CategoryCourse> getCategoryCourse(Pageable pageable){
        System.out.println("------------------------------------------------>get course");
        return categoryCourseRepo.findAll(pageable);
    }
    
     @RequestMapping(value = "/deletecategorycourse",method = RequestMethod.POST)
    public void deleteCourse(@RequestBody CategoryCourse course){
        categoryCourseRepo.delete(course.getId());
    }
}

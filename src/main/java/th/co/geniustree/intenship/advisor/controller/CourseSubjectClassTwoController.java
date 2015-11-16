
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassOne;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassTwo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassTwoRepo;

/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassTwoController {
    @Autowired
    private CourseSubjectClassTwoRepo courseSubjectClassTwoRepo;
    
    @RequestMapping(value = "/getcoursesubjectclasstwo",method = RequestMethod.GET)
    public Page<CourseSubjectClassTwo> getCourseSubjectClassOne (Pageable pageable){
        return courseSubjectClassTwoRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savecoursesubjectclasstwo",method = RequestMethod.POST)
    public void saveCourseSubjectClassTwo(@Validated @RequestBody CourseSubjectClassTwo courseClass){
        courseSubjectClassTwoRepo.save(courseClass);
    }
    
    @RequestMapping(value = "/deletecoursesubjectclasstwo",method = RequestMethod.POST)
    public void deleteCourseSubjectClassTwo(@RequestBody CourseSubjectClassTwo courseClass){
        courseSubjectClassTwoRepo.delete(courseClass);
    }
}

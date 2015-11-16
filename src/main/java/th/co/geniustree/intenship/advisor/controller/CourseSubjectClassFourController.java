
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassFour;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassFourRepo;

/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassFourController {
    @Autowired
    private CourseSubjectClassFourRepo courseSubjectClassFourRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassfour",method = RequestMethod.GET)
    public Page<CourseSubjectClassFour> getCourseSubjectClassOne (Pageable pageable){
        return courseSubjectClassFourRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savecoursesubjectclassfour",method = RequestMethod.POST)
    public void saveCourseSubjectClassOne(@Validated @RequestBody CourseSubjectClassFour courseClass){
        courseSubjectClassFourRepo.save(courseClass);
    }
    
    @RequestMapping(value = "/deletecoursesubjectclassfour",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOne(@RequestBody CourseSubjectClassFour courseClass){
        courseSubjectClassFourRepo.delete(courseClass);
    }
}

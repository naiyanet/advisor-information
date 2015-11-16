
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassOneTwo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassOneTwoRepo;


/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassOneTwoController {
    
    @Autowired
    private CourseSubjectClassOneTwoRepo courseSubjectClassOneTwoRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassonetermtwo",method = RequestMethod.GET)
    public Page<CourseSubjectClassOneTwo> getCourseSubjectClassOneTwo (Pageable pageable){
        return courseSubjectClassOneTwoRepo.findAll(pageable);
    }
    @RequestMapping(value = "/savecoursesubjectclassonetermtwo",method = RequestMethod.POST)
    public void saveCourseSubjectClassOneTwo(@Validated @RequestBody CourseSubjectClassOneTwo classOneTwo){
        courseSubjectClassOneTwoRepo.save(classOneTwo);
    }
    @RequestMapping(value = "/deletecoursesubjectclassonetermtwo",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOneTwo(@RequestBody CourseSubjectClassOneTwo classOneTwo){
        courseSubjectClassOneTwoRepo.delete(classOneTwo);
    }
}

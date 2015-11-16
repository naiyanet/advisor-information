
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassThreeTwo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassThreeTwoRepo;


/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassThreeTwoController {
    
    @Autowired
    private CourseSubjectClassThreeTwoRepo courseSubjectClassThreeTwoRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassthreetermtwo",method = RequestMethod.GET)
    public Page<CourseSubjectClassThreeTwo> getCourseSubjectClassThreeTwo (Pageable pageable){
        return courseSubjectClassThreeTwoRepo.findAll(pageable);
    }
    @RequestMapping(value = "/savecoursesubjectclassthreetermtwo",method = RequestMethod.POST)
    public void saveCourseSubjectClassOneTwo(@Validated @RequestBody CourseSubjectClassThreeTwo classOneTwo){
        courseSubjectClassThreeTwoRepo.save(classOneTwo);
    }
    @RequestMapping(value = "/deletecoursesubjectclassthreetermtwo",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOneTwo(@RequestBody CourseSubjectClassThreeTwo classOneTwo){
        courseSubjectClassThreeTwoRepo.delete(classOneTwo);
    }
}

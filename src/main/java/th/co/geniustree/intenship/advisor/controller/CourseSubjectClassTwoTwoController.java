
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassTwoTwo;
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassTwoTwoRepo;


/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassTwoTwoController {
    
    @Autowired
    private CourseSubjectClassTwoTwoRepo courseSubjectClassTwoTwoRepo;
    
    @RequestMapping(value = "/getcoursesubjectclasstwotermtwo",method = RequestMethod.GET)
    public Page<CourseSubjectClassTwoTwo> getCourseSubjectClassOneTwo (Pageable pageable){
        return courseSubjectClassTwoTwoRepo.findAll(pageable);
    }
    @RequestMapping(value = "/savecoursesubjectclasstwotermtwo",method = RequestMethod.POST)
    public void saveCourseSubjectClassOneTwo(@Validated @RequestBody CourseSubjectClassTwoTwo classOneTwo){
        courseSubjectClassTwoTwoRepo.save(classOneTwo);
    }
    @RequestMapping(value = "/deletecoursesubjectclasstwotermtwo",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOneTwo(@RequestBody CourseSubjectClassTwoTwo classOneTwo){
        courseSubjectClassTwoTwoRepo.delete(classOneTwo);
    }
}

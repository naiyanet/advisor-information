
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
import th.co.geniustree.intenship.advisor.repo.CourseSubjectClassOneRepo;

/**
 *
 * @author User
 */
@RestController
public class CourseSubjectClassOneController {
    @Autowired
    private CourseSubjectClassOneRepo courseSubjectClassOneRepo;
    
    @RequestMapping(value = "/getcoursesubjectclassone",method = RequestMethod.GET)
    public Page<CourseSubjectClassOne> getCourseSubjectClassOne (Pageable pageable){
        return courseSubjectClassOneRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savecoursesubjectclassone",method = RequestMethod.POST)
    public void saveCourseSubjectClassOne(@Validated @RequestBody CourseSubjectClassOne courseClass){
        courseSubjectClassOneRepo.save(courseClass);
    }
    
    @RequestMapping(value = "/deletecoursesubjectclassone",method = RequestMethod.POST)
    public void deleteCourseSubjectClassOne(@RequestBody CourseSubjectClassOne courseClass){
        courseSubjectClassOneRepo.delete(courseClass);
    }
}

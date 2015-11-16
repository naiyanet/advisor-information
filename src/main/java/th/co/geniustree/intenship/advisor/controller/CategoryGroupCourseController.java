
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CategoryGroupCourse;
import th.co.geniustree.intenship.advisor.repo.CategoryGroupCourseRepo;

/**
 *
 * @author User
 */
@RestController
public class CategoryGroupCourseController {
    @Autowired
    private CategoryGroupCourseRepo categoryGroupCourseRepo;
    
    @RequestMapping(value = "/getcategorygroupcourse",method = RequestMethod.GET)
    public Page<CategoryGroupCourse> getCategoryGroupCourse (Pageable pageable){
        return categoryGroupCourseRepo.findAll(pageable);
    }
}

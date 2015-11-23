
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.Teacher;
import th.co.geniustree.intenship.advisor.repo.TeacherRepo;

/**
 *
 * @author User
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherRepo teacherRepo;
    
    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public Page<Teacher> getTeacher(Pageable pageable){
        return teacherRepo.findAll(pageable);
    } 
    @RequestMapping(value = "/saveteacher",method = RequestMethod.POST)
    public void saveTeacher(@Validated @RequestBody Teacher teacher){
        teacherRepo.save(teacher);
    }
    @RequestMapping(value = "/deleteTeacher",method = RequestMethod.POST)
    public void deleteTeacher(@RequestBody Teacher teacher){
        teacherRepo.delete(teacher.getId());
    }
    @RequestMapping(value = "/teacher/search", method = RequestMethod.POST)
    public Page<Teacher> searchTeacher(@RequestBody String keyword, Pageable pageable) {
        return teacherRepo.findByNameOrEmail(keyword, keyword, pageable);
    }

}

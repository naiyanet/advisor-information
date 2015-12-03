
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.SearchData;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.model.Timetable;
import th.co.geniustree.intenship.advisor.repo.TimetableRepo;
import th.co.geniustree.intenship.advisor.service.StudentSearchService;
import th.co.geniustree.intenship.advisor.service.TimetableSearchService;

/**
 *
 * @author User
 */
@RestController
public class TimetableController {
    @Autowired
    private TimetableRepo timetableRepo;
    
    @Autowired
    private TimetableSearchService timetableSearchService;
    
    @Autowired
    private StudentSearchService studentSearchService;
    
    @RequestMapping(value = "/timetable",method = RequestMethod.POST)
    public Page<Timetable> getTimetable(@RequestBody SearchData searchData, Pageable pageable){
        String searchBy = searchData.getSearchBy();
        String keyword = searchData.getKeyWord();
        Page<Timetable> timetables = null;
        if ("Teacher".equals(searchBy)){
            timetables = timetableSearchService.searchNameTeacherTimetable(keyword, pageable);
        }if("Student".equals(searchBy)){
            timetables = timetableSearchService.searchNameStudentTimetable(keyword, pageable);
        }if("Parent".equals(searchBy)){
            timetables = timetableSearchService.searchParent(keyword, pageable);
        }
        return timetables;
    }
    
    @RequestMapping(value = "/savetimetable",method = RequestMethod.POST)
    public void saveTimetable(@Validated @RequestBody Timetable timetable){
        timetableRepo.save(timetable);
    }
    
    @RequestMapping(value = "/deletetimetable",method = RequestMethod.POST)
    public void deleteTimetable(@RequestBody Timetable timetable){
        timetableRepo.delete(timetable.getId());
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public Page<Student>getStudentAllTeacher(@RequestBody Integer keyword, Pageable pageable){
        Page<Student>students = studentSearchService.searchStudentByTeacher(keyword, pageable);
        return students;
    }
}

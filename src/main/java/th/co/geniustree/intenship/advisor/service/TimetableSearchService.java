/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Timetable;
import th.co.geniustree.intenship.advisor.repo.TimetableRepo;
import th.co.geniustree.intenship.advisor.spec.TimetableSpec;

/**
 *
 * @author momo
 */
@Service
public class TimetableSearchService {
    @Autowired
    private TimetableRepo timetableRepo;
    
    public Page<Timetable>searchNameStudentTimetable(String keyword,Pageable pageable){
        Specifications<Timetable>specifications = Specifications.where(TimetableSpec.nameLike("%"+keyword+"%"));
        return timetableRepo.findAll(specifications, pageable);
    }
    
    public Page<Timetable>searchParent(String keyword,Pageable pageable){
        Specifications<Timetable>specifications = Specifications.where(TimetableSpec.nameParent(keyword));
        return timetableRepo.findAll(specifications, pageable);
    }
    
    public Page<Timetable>searchNameTeacherTimetable(String keyword,Pageable pageable){
        Specifications<Timetable>specifications = Specifications.where(TimetableSpec.nameTeacherLike("%"+keyword+"%"));
        return timetableRepo.findAll(specifications, pageable);
    }
}

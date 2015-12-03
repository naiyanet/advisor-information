/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Account_;
import th.co.geniustree.intenship.advisor.model.Parent_;
import th.co.geniustree.intenship.advisor.model.Student_;
import th.co.geniustree.intenship.advisor.model.Timetable;
import th.co.geniustree.intenship.advisor.model.Timetable_;

/**
 *
 * @author momo
 */
public class TimetableSpec {
    public static Specification<Timetable>nameLike(final String keyword){
        return new Specification(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb){
                return cb.like(cb.upper(root.get(Timetable_.account).get(Account_.name)), keyword.toUpperCase());
            }
        };
    }
    
    public static  Specification<Timetable>nameParent(final String keyword){
        return new Specification(){
            @Override
            public Predicate toPredicate(Root root,CriteriaQuery cq,CriteriaBuilder cb){
                return cb.like(cb.upper(root.get(Timetable_.account).get(Student_.parent).get(Parent_.name)), keyword.toUpperCase());
            }
        }; 
    }
    
    public static Specification<Timetable>nameTeacherLike(final String keyword){
        return new Specification(){
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb){
                return cb.like(cb.upper(root.get(Timetable_.account).get(Account_.name)), keyword.toUpperCase());
            }
        };
    }
}

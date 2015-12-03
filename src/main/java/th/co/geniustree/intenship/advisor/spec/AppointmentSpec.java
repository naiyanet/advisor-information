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
import th.co.geniustree.intenship.advisor.model.Appointment;
import th.co.geniustree.intenship.advisor.model.Appointment_;
import th.co.geniustree.intenship.advisor.model.Student_;

/**
 *
 * @author momo
 */
public class AppointmentSpec {
    public static Specification<Appointment> nameLike(final String keyword) {
        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Appointment_.student).get(Student_.name)), keyword.toUpperCase());
            }
        };
    }
    
    public static Specification<Appointment>nameTeacherLike(final String keyword){
        return new Specification(){
            @Override
            public Predicate toPredicate(Root root,CriteriaQuery cq, CriteriaBuilder cb){
                return cb.like(cb.upper(root.get(Appointment_.teacher).get(Student_.name)),keyword.toUpperCase());
            }
        };
    }
}

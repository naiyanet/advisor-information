/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.spec;

import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Information;
import th.co.geniustree.intenship.advisor.model.Information_;

/**
 *
 * @author User
 */
public class InformationSpec {
    public static Specification<Information> titleLike(final String keyword) {
        return  new Specification<Information>(){

            @Override
            public Predicate toPredicate(Root<Information> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Information_.title)), keyword.toUpperCase());
            }
        };
    }
    
    public static Specification<Information> startTimeLike(final Date start,final Date end) {
        String startTime = Information_.startTime + "";
        return  new Specification<Information>(){

            @Override
            public Predicate toPredicate(Root<Information> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.between(root.get(Information_.startTime), start, end);
            }
        };
    }
    
}

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
import th.co.geniustree.intenship.advisor.model.Faculty;
import th.co.geniustree.intenship.advisor.model.Faculty_;

/**
 *
 * @author User
 */
public class FacultySpec {

    public static Specification<Faculty> nameLike(final String keyword) {
        return new Specification<Faculty>() {

            @Override
            public Predicate toPredicate(Root<Faculty> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Faculty_.name)), keyword.toUpperCase());
            }
        };
    }
}

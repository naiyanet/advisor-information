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
import th.co.geniustree.intenship.advisor.model.CategoryAdvise;
import th.co.geniustree.intenship.advisor.model.CategoryAdvise_;

/**
 *
 * @author User
 */
public class CategoryAdviseSpec {
    public static Specification<CategoryAdvise> nameCategoryLike(final String keyword){
        return new Specification<CategoryAdvise>(){

            @Override
            public Predicate toPredicate(Root<CategoryAdvise> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(CategoryAdvise_.nameCategory)), keyword.toUpperCase());
            }
            
        };
    }
}


package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Teacher;
import th.co.geniustree.intenship.advisor.model.Teacher_;


/**
 *
 * @author User
 */
public class TeacherSpec {
    public static Specification<Teacher> nameLike(final String keyword){
        return new Specification<Teacher>() {

            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Teacher_.name)), keyword.toUpperCase());
            }
        };
    }
    public static Specification<Teacher> emailLike(final String keyword){
        return new Specification<Teacher>() {

            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Teacher_.email)), keyword.toUpperCase());
            }
        };
    }
}

   

package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Behavior;
import th.co.geniustree.intenship.advisor.model.Behavior_;
import th.co.geniustree.intenship.advisor.model.Student_;
import th.co.geniustree.intenship.advisor.model.Teacher_;

/**
 *
 * @author User
 */
public class BehaviorSpec {

    public static Specification<Behavior> nameLike(final String keyword) {
        return new Specification() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Behavior_.student).get(Student_.name)), keyword.toUpperCase());
            }

        };
    }

    public static Specification<Behavior> idTeacherLike(final Integer keyword) {
        return new Specification() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(cb.upper(root.get(Behavior_.teacher).get(Teacher_.id)),keyword);
            }
        };
    }
    
}

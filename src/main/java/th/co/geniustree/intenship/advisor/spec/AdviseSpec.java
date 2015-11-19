package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Advise;
import th.co.geniustree.intenship.advisor.model.Advise_;
import th.co.geniustree.intenship.advisor.model.Student_;

/**
 *
 * @author User
 */
public class AdviseSpec {

    public static Specification<Advise> nameLike(final String keyword) {
        return new Specification() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Advise_.student).get(Student_.name)), keyword.toUpperCase());
            }
        };
    }

    public static Specification<Advise> nameTeacherLike(final String keyword) {
        return new Specification() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Advise_.teacher).get(Student_.name)), keyword.toUpperCase());
            }
        };
    }

}

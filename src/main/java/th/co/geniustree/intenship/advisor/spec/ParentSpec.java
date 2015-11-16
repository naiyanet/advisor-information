
package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Parent;
import th.co.geniustree.intenship.advisor.model.Parent_;


/**
 *
 * @author Account
 */
public class ParentSpec {

    public static Specification<Parent> nameLike(final String keyword) {
        return new Specification<Parent>() {

            @Override
            public Predicate toPredicate(Root<Parent> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Parent_.name)), keyword.toUpperCase());
            }

        };
    }

    public static Specification<Parent> emailLike(final String keyword) {
        return new Specification<Parent>() {

            @Override
            public Predicate toPredicate(Root<Parent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Parent_.email)), keyword.toUpperCase());
            }
        };
    }
}

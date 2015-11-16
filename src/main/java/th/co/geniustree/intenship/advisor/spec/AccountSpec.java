
package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Account;
import th.co.geniustree.intenship.advisor.model.Account_;


/**
 *
 * @author Account
 */
public class AccountSpec {

    public static Specification<Account> nameLike(final String keyword) {
        return new Specification<Account>() {

            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Account_.name)), keyword.toUpperCase());
            }

        };
    }

    public static Specification<Account> emailLike(final String keyword) {
        return new Specification<Account>() {

            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Account_.email)), keyword.toUpperCase());
            }
        };
    }
}

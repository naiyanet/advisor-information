
package th.co.geniustree.intenship.advisor.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.model.Student_;
import th.co.geniustree.intenship.advisor.model.Teacher_;


/**
 *
 * @author User
 */
public class StudentSpec {
    public static Specification<Student> nameLike(final String keyword) {
        return new Specification<Student>() {

            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Student_.name)), keyword.toUpperCase());
                
            }
        };
    }

    public static Specification<Student> emailLike(final String keyword) {
        return new Specification<Student>() {

            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Student_.email)), keyword.toUpperCase());
            }
        };
    }
    
    public static Specification<Student> teacherId(final Integer id){
    return new Specification<Student>() {

        @Override
        public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
          return cb.equal(root.get(Student_.teacher).get(Teacher_.id), id);
        }
    };
    }
}



package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.intenship.advisor.model.Course;

/**
 *
 * @author User
 */
public interface CourseRepo extends JpaRepository<Course, Integer>{
    
}

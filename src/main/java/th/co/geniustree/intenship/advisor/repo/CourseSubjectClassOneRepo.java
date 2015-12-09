
package th.co.geniustree.intenship.advisor.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.intenship.advisor.model.CourseSubjectClassOne;

/**
 *
 * @author User
 */
public interface CourseSubjectClassOneRepo extends JpaRepository<CourseSubjectClassOne, Integer>{
    
    public List<CourseSubjectClassOne> findBySubjectName(String name);
    
}

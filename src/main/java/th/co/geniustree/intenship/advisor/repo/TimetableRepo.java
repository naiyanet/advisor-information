
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Timetable;

/**
 *
 * @author User
 */

public interface TimetableRepo extends JpaRepository<Timetable, Integer>,JpaSpecificationExecutor<Timetable>{
    
    
}

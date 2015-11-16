
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Behavior;

/**
 *
 * @author User
 */
public interface BehaviorRepo extends JpaRepository<Behavior, Integer>,JpaSpecificationExecutor<Behavior>{
    
}


package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Information;

/**
 *
 * @author User
 */
public interface InformationRepo extends JpaRepository<Information, Integer>,JpaSpecificationExecutor<Information>{
    
}

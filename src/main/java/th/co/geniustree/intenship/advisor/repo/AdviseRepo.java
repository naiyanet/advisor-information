
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Advise;

/**
 *
 * @author User
 */
public interface AdviseRepo extends JpaRepository<Advise, Integer>,JpaSpecificationExecutor<Advise>{

}

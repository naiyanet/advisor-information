
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Faculty;

/**
 *
 * @author User
 */
public interface FacultyRepo extends JpaRepository<Faculty,Integer>,JpaSpecificationExecutor<Faculty>{

    public Page<Faculty> findByName(String keyword, Pageable pageable);
    
}

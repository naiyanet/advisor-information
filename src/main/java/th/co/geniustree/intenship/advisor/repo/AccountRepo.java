
package th.co.geniustree.intenship.advisor.repo;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Account;

/**
 *
 * @author Account
 */
public interface AccountRepo extends JpaRepository<Account, Integer>,JpaSpecificationExecutor<Account>{

    public Optional<Account> findByEmail(String email);
    
    public Page<Account> findByDtype(String dtype , Pageable pageable);
    
    public Page<Account> findByDtypeAndName(String dtype , String name , Pageable pageable);
    
    public Page<Account> findByName(String keyword , Pageable pageable);
    
}

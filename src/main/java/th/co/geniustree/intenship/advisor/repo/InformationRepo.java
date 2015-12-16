
package th.co.geniustree.intenship.advisor.repo;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Information;

/**
 *
 * @author User
 */
public interface InformationRepo extends JpaRepository<Information, Integer>,JpaSpecificationExecutor<Information>{
    Page<Information> findAllByOrderByIdDesc(Pageable pageable);
    Page<Information> findByEndTimeBetweenOrderByIdDesc(Date d , Date dd , Pageable pageable);
    Page<Information> findByTitleOrderByIdDesc(String keyword , Pageable pageable);
    
}

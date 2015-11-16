
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.Student;

/**
 *
 * @author User
 */
public interface StudentRepo extends JpaRepository<Student, Integer>,JpaSpecificationExecutor<Student>{
    public Student findByEmail(String email);
    
    public Page<Student> findByNameOrEmail(String name, String email, Pageable pageable);
    public Student findByEmailIgnoreCase(String value);

    public Student findByMobileIgnoreCase(String value);
    
     public Student findByIdCardIgnoreCase(String value);
}

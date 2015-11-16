
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.intenship.advisor.model.Appointment;

/**
 *
 * @author User
 */
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{
    
}

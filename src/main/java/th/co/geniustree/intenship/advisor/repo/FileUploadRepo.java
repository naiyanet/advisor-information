
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.intenship.advisor.model.FileUpload;

/**
 *
 * @author User
 */
public interface FileUploadRepo extends JpaRepository<FileUpload, Integer>{
    
}

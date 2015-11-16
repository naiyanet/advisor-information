
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Advise;
import th.co.geniustree.intenship.advisor.repo.AdviseRepo;
import th.co.geniustree.intenship.advisor.spec.AdviseSpec;

/**
 *
 * @author User
 */
@Service
public class AdviseSearchService {
    @Autowired
    private AdviseRepo adviseRepo;
    
    public Page<Advise> searchNameStudentAdvise(String keyword,Pageable pageable){
        Specifications<Advise> specifications = Specifications.where(AdviseSpec.nameLike("%"+keyword+"%"));
        return adviseRepo.findAll(specifications,pageable);
    }
}

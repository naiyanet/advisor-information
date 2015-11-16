
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Parent;
import th.co.geniustree.intenship.advisor.repo.ParentRepo;
import th.co.geniustree.intenship.advisor.spec.ParentSpec;

/**
 *
 * @author User
 */
@Service
public class ParentSearchService {
    @Autowired
    private ParentRepo parentRepo;
    
    public Page<Parent> searchByNameOrEmail(String keyword, Pageable pageable){

        Specifications<Parent> specification = Specifications.where(ParentSpec.nameLike("%"+keyword+"%"))
                .or(ParentSpec.emailLike("%"+keyword+"%"));
        return  parentRepo.findAll(specification,pageable);
    }

}

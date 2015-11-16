
package th.co.geniustree.intenship.advisor.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Information;
import th.co.geniustree.intenship.advisor.repo.InformationRepo;
import th.co.geniustree.intenship.advisor.spec.InformationSpec;

/**
 *
 * @author User
 */
@Service
public class InformationSearchService {
    @Autowired
    private InformationRepo informationRepo;
    
    public Page<Information> searchByStartTime (Date start,Date end, Pageable pageble){
        Specification<Information> specification = Specifications.where(InformationSpec.startTimeLike(start,end));
        return informationRepo.findAll(specification, pageble);
    }
    
    public Page<Information> searchByTitle (String keyword,Pageable pageable){
        Specifications<Information> specification = Specifications.where(InformationSpec.titleLike("%"+keyword+"%"));
        return informationRepo.findAll(specification,pageable);
    }
}

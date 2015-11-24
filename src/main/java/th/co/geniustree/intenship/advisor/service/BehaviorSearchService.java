package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Behavior;
import th.co.geniustree.intenship.advisor.repo.BehaviorRepo;
import th.co.geniustree.intenship.advisor.spec.BehaviorSpec;

/**
 *
 * @author Naiyanet
 */
@Service
public class BehaviorSearchService {

    @Autowired
    private BehaviorRepo behaviorRepo;

    public Page<Behavior> searchNameStudentBehavior(String keyword, Pageable pageable) {
        Specifications<Behavior> specifications = Specifications.where(BehaviorSpec.nameLike("%" + keyword + "%"));
        return behaviorRepo.findAll(specifications, pageable);
    }
    public Page<Behavior> searchParentName(String keyword,Pageable pageable){
        Specifications<Behavior> specifications = Specifications.where(BehaviorSpec.nameParentLike("%"+keyword+"%"));
        return behaviorRepo.findAll(specifications,pageable);
    }
    
    public Page<Behavior> searchTeacherId(Integer keyword, Pageable pageable) {
        Specifications<Behavior> specifications = Specifications.where(BehaviorSpec.idTeacherLike(keyword));
        return behaviorRepo.findAll(specifications, pageable);
    }

    public Page<Behavior> searchTeacherName(String keyword, Pageable pageable) {
        Specifications<Behavior> specifications = Specifications.where(BehaviorSpec.NameTeacherLike("%" + keyword + "%"));
        return behaviorRepo.findAll(specifications, pageable);
    }

}

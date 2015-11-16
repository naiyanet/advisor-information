
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.CategoryAdvise;
import th.co.geniustree.intenship.advisor.repo.CategoryAdviseRepo;
import th.co.geniustree.intenship.advisor.spec.CategoryAdviseSpec;

/**
 *
 * @author User
 */
@Service
public class CategoryAdviseSearchService {

    @Autowired
    private CategoryAdviseRepo categoryAdviseRepo;

    public Page<CategoryAdvise> searchByNameCategory(String keyword, Pageable pageable) {
        Specification<CategoryAdvise> specification = Specifications.where(CategoryAdviseSpec.nameCategoryLike(keyword));
        return categoryAdviseRepo.findAll(specification, pageable);

    }
}

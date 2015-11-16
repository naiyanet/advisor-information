
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;
import th.co.geniustree.intenship.advisor.spec.StudentSpec;

/**
 *
 * @author User
 */
@Service
public class StudentSearchService {

    @Autowired
    private StudentRepo studentRepo;

    public Page<Student> search(String keyword, Pageable pageable) {
        Specifications<Student> specification = Specifications.where(StudentSpec.emailLike("%" + keyword + "%"))
                .or(StudentSpec.nameLike("%" + keyword + "%"));
        return studentRepo.findAll(specification, pageable);
    }
}

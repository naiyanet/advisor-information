
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Teacher;
import th.co.geniustree.intenship.advisor.repo.TeacherRepo;
import th.co.geniustree.intenship.advisor.spec.TeacherSpec;

/**
 *
 * @author User
 */
@Service
public class TeacherSearchService {

    @Autowired
    private TeacherRepo teacherRepo;

    public Page<Teacher> search(String keyword, Pageable pageable) {

        Specifications<Teacher> specification = Specifications.where(TeacherSpec.emailLike("%" + keyword + "%"))
                .or(TeacherSpec.emailLike("%" + keyword + "%"));
        return teacherRepo.findAll(specification, pageable);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship.advisor.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.intenship.advisor.App;
import th.co.geniustree.intenship.advisor.model.Teacher;
import th.co.geniustree.intenship.advisor.repo.TeacherRepo;
import th.co.geniustree.intenship.advisor.service.TeacherSearchService;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class TeacherSearchServiceSpecIT {

    @Autowired
    private TeacherSearchService teacherSearchService;
    @Autowired
    private TeacherRepo teacherRepo;
    private Teacher teacher;

    @Before
    public void setup() {
        teacher = new Teacher();
        teacher.setEmail("teacher@xxxx.com");
        teacher.setPassword("xxx");
        teacher.setName("xxxxx");
        teacher.setMobile("xxxxxx");
    }

    @Test
    public void findEmailTeacherShouldReturnOneRow() {
        teacherRepo.saveAndFlush(teacher);
        Page<Teacher> search = teacherSearchService.search("teacher", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void duplicateInsertMustNotAllow() {
        teacherRepo.save(teacher);
        teacherRepo.save(teacher);
        Page<Teacher> search = teacherRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void insertAndDeleteMustBeSuccess() {
        teacherRepo.save(teacher);
        Page<Teacher> search = teacherRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        teacherRepo.delete(teacher);
        Page<Teacher> searchAgain = teacherRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isZero();
    }

    @Test
    public void updateEmailMustBeSuccess() {
        teacherRepo.saveAndFlush(teacher);
        Page<Teacher> search = teacherSearchService.search("teacher", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        teacher.setEmail("xxxxxxx@xxxxx.com");
        Page<Teacher> searchAgain = teacherSearchService.search("xxxxxxx", new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isEqualTo(1);
    }
}

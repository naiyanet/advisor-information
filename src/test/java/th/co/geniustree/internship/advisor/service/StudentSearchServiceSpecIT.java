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
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;
import th.co.geniustree.intenship.advisor.service.StudentSearchService;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class StudentSearchServiceSpecIT {

    @Autowired
    private StudentSearchService studentSearchService;
    @Autowired
    private StudentRepo studentRepo;
    private Student student;

    @Before
    public void setup() {
        student = new Student();
        student.setEmail("student@xxxx.com");
        student.setPassword("xxx");
        //student.setIdCard(121212);
        student.setName("xxxxx");
        student.setMobile("xxxxxx");
    }

    @Test
    public void findEmailStudentShouldReturnOneRow() {
        studentRepo.saveAndFlush(student);
        Page<Student> search = studentSearchService.search("student", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void duplicateInsertMustNotAllow() {
        studentRepo.save(student);
        studentRepo.save(student);
        Page<Student> search = studentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void insertAndDeleteMustBeSuccess() {
        studentRepo.save(student);
        Page<Student> search = studentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        studentRepo.delete(student);
        Page<Student> searchAgain = studentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isZero();
    }

    @Test
    public void updateEmailMustBeSuccess() {
        studentRepo.saveAndFlush(student);
        Page<Student> search = studentSearchService.search("student", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        student.setEmail("xxxxxxx@xxxxx.com");
        Page<Student> searchAgain = studentSearchService.search("xxxxxxx", new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isEqualTo(1);
    }
}

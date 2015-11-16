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
import th.co.geniustree.intenship.advisor.model.Parent;
import th.co.geniustree.intenship.advisor.repo.ParentRepo;
import th.co.geniustree.intenship.advisor.service.ParentSearchService;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class ParentSearchServiceSpecIT {
    @Autowired
    private ParentSearchService parentSearchService;
    @Autowired
    private ParentRepo parentRepo;
    private Parent parent;
    
    @Before
    public void setup() {
        parent = new Parent();
        parent.setEmail("parent@xxxx.com");
        parent.setPassword("xxx");
        parent.setName("xxxxx");
        parent.setMobile("xxxxxx");
    }

    @Test
    public void findEmailParentShouldReturnOneRow() {
        parentRepo.saveAndFlush(parent);
        Page<Parent> search = parentSearchService.searchByNameOrEmail("parent", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void duplicateInsertMustNotAllow() {
        parentRepo.save(parent);
        parentRepo.save(parent);
        Page<Parent> search = parentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }

    @Test
    public void insertAndDeleteMustBeSuccess() {
        parentRepo.save(parent);
        Page<Parent> search = parentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        parentRepo.delete(parent);
        Page<Parent> searchAgain = parentRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isZero();
    }

    @Test
    public void updateEmailMustBeSuccess() {
        parentRepo.saveAndFlush(parent);
        Page<Parent> search = parentSearchService.searchByNameOrEmail("parent", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        parent.setEmail("xxxxxxx@xxxxx.com");
        Page<Parent> searchAgain = parentSearchService.searchByNameOrEmail("xxxxxxx", new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isEqualTo(1);
    }
}

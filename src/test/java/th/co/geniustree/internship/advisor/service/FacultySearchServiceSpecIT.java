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
import th.co.geniustree.intenship.advisor.model.Faculty;
import th.co.geniustree.intenship.advisor.repo.FacultyRepo;
import th.co.geniustree.intenship.advisor.service.FacultySearchService;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class FacultySearchServiceSpecIT {
    @Autowired
    private FacultySearchService facultySearchService;
    @Autowired
    private FacultyRepo facultyRepo;
    private Faculty faculty;
    @Before
    public void setup(){
        faculty = new Faculty();
        faculty.setName("xxxxxxx");   
    }
    @Test
    public void findNameDepartment(){
        facultyRepo.saveAndFlush(faculty);
        Page<Faculty> search = facultySearchService.search("xxx", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }
}

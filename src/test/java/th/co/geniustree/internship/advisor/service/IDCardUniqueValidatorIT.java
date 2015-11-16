/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship.advisor.service;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.iterable.Extractor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.intenship.advisor.App;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class IDCardUniqueValidatorIT {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private Validator validator;
    private Student student;

    @Before
    public void setUp() {
        student = new Student();
        
    }

    @Test
    public void ifIDCardIsAlreadyExistThenError() {
        Set<ConstraintViolation<Student>> validateProperty = validator.validateProperty(student, "ID Card");
        Assertions.assertThat(validateProperty).extracting(new Extractor<ConstraintViolation<Student>,String>(){

            @Override
            public String extract(ConstraintViolation<Student> f) {
                return f.getMessage();
            }
            
        }).contains("dublicateIDCard");
    }
}

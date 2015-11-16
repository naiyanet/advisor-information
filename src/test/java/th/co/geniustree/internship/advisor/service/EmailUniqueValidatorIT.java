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
public class EmailUniqueValidatorIT {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private Validator validator;
    private Student student;

    @Before
    public void setup() {
        student = new Student();
        student.setEmail("stdent@xxx.Com");
        student.setPassword("xxx");
        //student.setIdCard(123);
        student.setName("xxxxx");
        student.setMobile("xxxxxx");
        student = studentRepo.save(student);
    }

    @Test
    public void ifAlreadyExistEmailThenError() {
        Set<ConstraintViolation<Student>> validateProperty = validator.validateProperty(student, "email");
        Assertions.assertThat(validateProperty).extracting(new Extractor<ConstraintViolation<Student>,String>(){

            @Override
            public String extract(ConstraintViolation<Student> f) {
                return f.getMessage();
            }
            
        }).contains("dublicateEmail");
    }
}

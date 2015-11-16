
package th.co.geniustree.intenship.advisor.validator;

import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;

/**
 *
 * @author User
 */
public class IDCardUniqueValidator implements ConstraintValidator<IDCardUnique, String>{
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public void initialize(IDCardUnique constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) {
            return true;
        }
        Student findByPidIgnoreCase = studentRepo.findByIdCardIgnoreCase(value);
        return findByPidIgnoreCase == null;
    }
}

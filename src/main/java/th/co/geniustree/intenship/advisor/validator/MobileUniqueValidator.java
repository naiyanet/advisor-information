/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.validator;


import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;

/**
 *
 * @author User
 */
public class MobileUniqueValidator implements ConstraintValidator<MobileUnique,String>{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void initialize(MobileUnique constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         
        if(Strings.isNullOrEmpty(value)){
        return true;
        }
        return studentRepo.findByMobileIgnoreCase(value) == null;
    }    
}

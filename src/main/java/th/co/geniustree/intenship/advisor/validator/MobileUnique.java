/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
/**
 *
 * @author User
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MobileUniqueValidator.class)
public @interface MobileUnique {
   
    String message() default "{th.co.geniustree.intenship.advisor.validator.MobileUnique.message}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
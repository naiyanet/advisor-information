
package th.co.geniustree.intenship.advisor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author User
 */
@Configuration
public class BeanValidatorConfig {
    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    } 
}

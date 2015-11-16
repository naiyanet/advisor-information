
package th.co.geniustree.intenship.advisor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import th.co.geniustree.intenship.advisor.service.MyUserDetailService;

/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/authentication")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/index-template.html")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index.html")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .headers()
                .frameOptions()
                .disable()
//                .and()
                .authorizeRequests().anyRequest().authenticated();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()
                .antMatchers("/console/*")
                .antMatchers("/css/**")
                .antMatchers("/datafullcalender/**")
                .antMatchers("/image/**")
                .antMatchers("/js/**")
                .antMatchers("/less/**")
                .antMatchers("/material/**")
                .antMatchers("/css/**")
                .antMatchers("/index.html")
                .antMatchers("/scripts/**/*.{js,html}");
    }

}

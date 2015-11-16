
package th.co.geniustree.intenship.advisor.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Account;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;
import th.co.geniustree.intenship.advisor.repo.AccountRepo;

/**
 *
 * @author Account
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> findByEmail = accountRepo.findByEmail(username);
        return findByEmail.orElseThrow(()->new UsernameNotFoundException("not found user."));
    }
}


package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Account;
import th.co.geniustree.intenship.advisor.repo.AccountRepo;
import th.co.geniustree.intenship.advisor.spec.AccountSpec;

/**
 *
 * @author User
 */
@Service
public class AccountSearchService {
    @Autowired 
    private AccountRepo accountRepo;
    
    public Page<Account> searchAccount(String keyword, Pageable pageable){
        
        Specifications<Account> specifications = Specifications.where(AccountSpec.emailLike("%"+keyword+"%"))
                .or(AccountSpec.nameLike("%"+keyword+"%"));
        return accountRepo.findAll(specifications,pageable);
    }
}

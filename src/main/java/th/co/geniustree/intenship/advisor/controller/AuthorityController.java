/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.Authority;
import th.co.geniustree.intenship.advisor.repo.AuthorityRepo;


/**
 *
 * @author User
 */
@RestController
public class AuthorityController {
    @Autowired
    private AuthorityRepo authorityRepo;
    
    @RequestMapping(value = "/authority")
    public Page<Authority> getAuthority(Pageable pageable) {
        return authorityRepo.findAll(pageable);
    }
}

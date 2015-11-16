/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.intenship.advisor.model.Faculty;
import th.co.geniustree.intenship.advisor.repo.FacultyRepo;
import th.co.geniustree.intenship.advisor.spec.FacultySpec;

/**
 *
 * @author User
 */
@Service
public class FacultySearchService {

    @Autowired
    private FacultyRepo facultyRepo;

    public Page<Faculty> search(String keyword, Pageable pageable) {

        Specifications<Faculty> specification = Specifications.where(FacultySpec.nameLike("%" + keyword + "%"));
        return facultyRepo.findAll(specification, pageable);
    }
}

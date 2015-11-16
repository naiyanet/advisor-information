/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.Faculty;
import th.co.geniustree.intenship.advisor.repo.FacultyRepo;

/**
 *
 * @author User
 */
@RestController
public class FacultyController {
    @Autowired
    private FacultyRepo facultyRepo;
    
    @RequestMapping(value = "/faculty")
    public Page<Faculty> getFaculty(Pageable pageable){
        return facultyRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/saveFaculty", method = RequestMethod.POST)
    public void saveFaculty(@Validated @RequestBody Faculty faculty){
        facultyRepo.save(faculty);
    }
    
    @RequestMapping(value = "/deleteFaculty", method = RequestMethod.POST)
    public void deleteFaculty(@RequestBody Faculty faculty){
        facultyRepo.delete(faculty.getId());
    }
    
    @RequestMapping(value = "/faculty/search", method = RequestMethod.POST)
    public Page<Faculty> searchFaculty(@RequestBody String keyword, Pageable pageable) {
        
        if(keyword.equals("s"))
        {
           return facultyRepo.findAll(pageable);
        }
        else{
           return facultyRepo.findByName(keyword, pageable);
        }
        
    }
}

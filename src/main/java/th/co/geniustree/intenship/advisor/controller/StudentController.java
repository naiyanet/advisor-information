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
import th.co.geniustree.intenship.advisor.model.Parent;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.AccountRepo;
import th.co.geniustree.intenship.advisor.repo.StudentRepo;
import th.co.geniustree.intenship.advisor.service.StudentSearchService;

/**
 *
 * @author User
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentSearchService searchService;
    @Autowired
    private AccountRepo  accountRepo;
    
    @RequestMapping (value = "/getstudent",method = RequestMethod.GET)
    public Page<Student> getStudent(Pageable pageable){
        return studentRepo.findAll(pageable);
    }
    
    @RequestMapping (value = "/savestudent",method = RequestMethod.POST)
    public void saveStudent(@Validated @RequestBody Student student){
        studentRepo.save(student);
    }
    
    @RequestMapping (value = "/deletestudent",method = RequestMethod.POST)
    public void deleteStudent(@RequestBody Student student){
        studentRepo.delete(student);
    }
    
    @RequestMapping(value = "/student/search", method = RequestMethod.POST)
    public Page<Student> searchParent(@RequestBody String keyword, Pageable pageable) {
        return searchService.search(keyword, pageable);
    }
    
    @RequestMapping(value = "/countstudent",method = RequestMethod.GET)
    public Long countParent (Pageable pageable){
        return accountRepo.findByDtype("Student", pageable).getTotalElements();
    }
}

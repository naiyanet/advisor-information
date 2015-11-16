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
import th.co.geniustree.intenship.advisor.model.CategoryAdvise;
import th.co.geniustree.intenship.advisor.repo.CategoryAdviseRepo;
import th.co.geniustree.intenship.advisor.service.CategoryAdviseSearchService;

/**
 *
 * @author User
 */
@RestController
public class CategoryAdviseController {

    @Autowired
    private CategoryAdviseRepo categoryAdviseRepo;
    @Autowired
    private CategoryAdviseSearchService adviseSearchService;
    
    
    @RequestMapping(value = "/getcategory", method = RequestMethod.GET)
    public Page<CategoryAdvise> getCategory(Pageable pageable) {
        return categoryAdviseRepo.findAll(pageable);
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public void saveCategory(@Validated @RequestBody CategoryAdvise category) {
        categoryAdviseRepo.save(category);
    }

    @RequestMapping(value = "/deletecategory", method = RequestMethod.POST)
    public void deleteCategory(@RequestBody CategoryAdvise category){
        categoryAdviseRepo.delete(category);
    }
    @RequestMapping(value = "/categoryadvise/search", method = RequestMethod.POST)
    public Page<CategoryAdvise> searchParent(@RequestBody String keyword, Pageable pageable) {
        return adviseSearchService.searchByNameCategory(keyword, pageable);
    }
}

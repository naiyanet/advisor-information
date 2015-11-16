/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.CategoryCourse;
import th.co.geniustree.intenship.advisor.model.CategoryGroupCourse;
import th.co.geniustree.intenship.advisor.model.SelectCategory;
import th.co.geniustree.intenship.advisor.repo.SelectCategoryRepo;

/**
 *
 * @author User
 */
@RestController
public class SelectCategoryController {
    
    @Autowired
    private SelectCategoryRepo selectCategoryRepo;
    
    @RequestMapping(value = "/getselectcategory",method = RequestMethod.GET)
    public Page<SelectCategory> getSelectCategory(Pageable pageable){
        return selectCategoryRepo.findAll(pageable);
    }
    @RequestMapping(value = "/saveselectcategory",method = RequestMethod.POST)
    public void saveSelectCategory(@RequestBody SelectCategory selectCategory){
      selectCategoryRepo.save(selectCategory);
    }
    
    @RequestMapping(value = "/deleteselectcategory",method = RequestMethod.POST)
    public Page<SelectCategory> deleteSelectCategory(@RequestBody SelectCategory selectCategory , Pageable pageable){
        selectCategoryRepo.delete(selectCategory);
        return selectCategoryRepo.findAll(pageable);
    }
}

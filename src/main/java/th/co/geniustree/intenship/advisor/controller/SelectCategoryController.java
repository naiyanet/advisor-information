
package th.co.geniustree.intenship.advisor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public List<SelectCategory> getSelectCategory(){
        return selectCategoryRepo.findAll();
    }
    @RequestMapping(value = "/saveselectcategory",method = RequestMethod.POST)
    public void saveSelectCategory(@Validated @RequestBody SelectCategory selectCategory){
      selectCategoryRepo.save(selectCategory);
    }
    
    @RequestMapping(value = "/deleteselectcategory",method = RequestMethod.POST)
    public void deleteSelectCategory(@RequestBody Integer selectCategory){
        selectCategoryRepo.delete(selectCategory);
    }

    
}

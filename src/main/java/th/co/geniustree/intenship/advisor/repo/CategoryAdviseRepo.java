/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.intenship.advisor.model.CategoryAdvise;

/**
 *
 * @author User
 */
public interface CategoryAdviseRepo extends JpaRepository<CategoryAdvise, Integer>,JpaSpecificationExecutor<CategoryAdvise>{
    public Page<CategoryAdvise> findByNameCategory(String name,Pageable pageable);
}

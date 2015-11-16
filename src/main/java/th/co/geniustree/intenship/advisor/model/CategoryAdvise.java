/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CATEGORYADVISE")
public class CategoryAdvise implements Serializable {

    @Id
    @SequenceGenerator(name = "CATEGORYADVISE", sequenceName = "CATEGORYADVISE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CATEGORYADVISE", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    
    private String nameCategory;
    
    @OneToMany(mappedBy = "categoryAdvise")
    @JsonIgnore
    private List<Advise> advises;
    
    public Integer getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public List<Advise> getAdvises() {
        return advises;
    }

    public void setAdvises(List<Advise> advises) {
        this.advises = advises;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoryAdvise other = (CategoryAdvise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CATEGORY_COURSE")
public class CategoryCourse implements Serializable{
    @Id 
    @SequenceGenerator(name = "CATEGORYCOURSE", sequenceName = "CATEGORYCOURSE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CATEGORYCOURSE", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String categoryCourseName;
    
    
//    @ManyToOne
//    private Course course;
    
    @OneToMany(mappedBy = "categoryCourse")
    private List<CategoryGroupCourse> categoryGroupCourse;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryCourseName() {
        return categoryCourseName;
    }

    public void setCategoryCourseName(String categoryCourseName) {
        this.categoryCourseName = categoryCourseName;
    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public List<CategoryGroupCourse> getCategoryGroupCourse() {
        return categoryGroupCourse;
    }

    public void setCategoryGroupCourse(List<CategoryGroupCourse> categoryGroupCourse) {
        this.categoryGroupCourse = categoryGroupCourse;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final CategoryCourse other = (CategoryCourse) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoryCourse{" + "id=" + id + ", categoryCourseName=" + categoryCourseName + ", categoryGroupCourse=" + categoryGroupCourse + '}';
    }
    
    
}

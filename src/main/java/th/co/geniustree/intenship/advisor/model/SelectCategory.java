
package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "SELECTCATEGORY")
public class SelectCategory implements Serializable {

    @Id
    @SequenceGenerator(name = "SELECTCATEGORY", sequenceName = "SELECTCATEGORY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "SELECTCATEGORY", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String subjectCode;
    private String subjectName;
    private String credit;
    private String categoryCourse;
    private String categoryGroupCourse;
    
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCategoryCourse() {
        return categoryCourse;
    }

    public void setCategoryCourse(String categoryCourse) {
        this.categoryCourse = categoryCourse;
    }

    public String getCategoryGroupCourse() {
        return categoryGroupCourse;
    }

    public void setCategoryGroupCourse(String categoryGroupCourse) {
        this.categoryGroupCourse = categoryGroupCourse;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final SelectCategory other = (SelectCategory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SelectCategory{" + "id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", credit=" + credit + ", categoryCourse=" + categoryCourse + ", categoryGroupCourse=" + categoryGroupCourse + '}';
    }

}

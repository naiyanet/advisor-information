
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
@Table(name = "STUDENT_CLASS_YEAR")
public class StudentClassYear implements Serializable{
    @Id
    @SequenceGenerator(name = "STUDENTCLASSYEAR",sequenceName = "STUDENTCLASSYEAR_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "STUDENTCLASSYEAR",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String classYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final StudentClassYear other = (StudentClassYear) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

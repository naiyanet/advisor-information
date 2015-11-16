
package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
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
@Table(name = "COURSE_SUBJECT_CLASS_FOUR_TERM2")
public class CourseSubjectClassFourTwo implements Serializable{
    @Id
    @SequenceGenerator(name = "COURSESUBJECTCLASSFOURTWO",sequenceName = "COURSESUBJECTCLASSFOURTWO_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "COURSESUBJECTCLASSFOURTWO",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String subjectCode;
    private String subjectName;
    private String credit;

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
    
    
}

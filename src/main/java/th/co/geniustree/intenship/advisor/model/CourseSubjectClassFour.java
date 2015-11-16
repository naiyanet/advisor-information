/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "COURSE_SUBJECT_CLASS_FOUR")
public class CourseSubjectClassFour implements Serializable{
    @Id
    @SequenceGenerator(name = "COURSESUBJECTCLASSFOUR",sequenceName = "COURSESUBJECTCLASSFOUR_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "COURSESUBJECTCLASSFOUR",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String subjectCode;
    private String subjectName;
    private String credit;
    
    private StudentClassYear studentClassYear;

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

    public StudentClassYear getStudentClassYear() {
        return studentClassYear;
    }

    public void setStudentClassYear(StudentClassYear studentClassYear) {
        this.studentClassYear = studentClassYear;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final CourseSubjectClassFour other = (CourseSubjectClassFour) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

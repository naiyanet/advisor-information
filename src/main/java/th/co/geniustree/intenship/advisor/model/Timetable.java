
package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "TIMETABLE")
public class Timetable implements Serializable{
    @Id
    @SequenceGenerator(name = "TIMETABLE", sequenceName = "TEACHER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TIMETABLE", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private Integer idSubjects;
    private String subjects;
    private Integer startT;
    private Integer startTm;
    private Integer endT;
    private Integer endTm;
    private String day;
    
    @OneToOne
    @JoinColumn(name = "account")
    private Account account;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSubjects() {
        return idSubjects;
    }

    public void setIdSubjects(Integer idSubjects) {
        this.idSubjects = idSubjects;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Integer getStartT() {
        return startT;
    }

    public void setStartT(Integer startT) {
        this.startT = startT;
    }

    public Integer getStartTm() {
        return startTm;
    }

    public void setStartTm(Integer startTm) {
        this.startTm = startTm;
    }

    public Integer getEndT() {
        return endT;
    }

    public void setEndT(Integer endT) {
        this.endT = endT;
    }

    public Integer getEndTm() {
        return endTm;
    }

    public void setEndTm(Integer endTm) {
        this.endTm = endTm;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        final Timetable other = (Timetable) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

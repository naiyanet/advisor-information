
package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ADVISE")
public class Advise implements Serializable{
    @Id
    @SequenceGenerator(name = "ADVISE", sequenceName = "ADVISE_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "ADVISE",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String idSubject;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dates;
    
    private String title;
    private String detail;
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    private FileUpload fileUpload;
    
    @ManyToOne
    private CategoryAdvise categoryAdvise;
 
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Teacher teacher;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    public CategoryAdvise getCategoryAdvise() {
        return categoryAdvise;
    }

    public void setCategoryAdvise(CategoryAdvise categoryAdvise) {
        this.categoryAdvise = categoryAdvise;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Advise other = (Advise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

      
}

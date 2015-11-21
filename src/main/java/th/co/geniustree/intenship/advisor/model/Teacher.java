
package th.co.geniustree.intenship.advisor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import th.co.geniustree.intenship.advisor.controller.View;

/**
 *
 * @author User
 */
@Entity
public class Teacher extends Account implements Serializable{

    @ManyToOne
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
    
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonManagedReference
    @OneToMany(mappedBy = "teacher")
    private List<Student> student;
    
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Advise> advisess; 
    
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Behavior> behaviors;

    @JsonView(Object.class)
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
      
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Advise> getAdvisess() {
        return advisess;
    }

    public void setAdvisess(List<Advise> advisess) {
        this.advisess = advisess;
    }

    public List<Behavior> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }
    
    
    
    
    
}

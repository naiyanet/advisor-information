
package th.co.geniustree.intenship.advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class Teacher extends Account implements Serializable{

    @ManyToOne
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Student> student;
    
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Advise> advisess; 
    
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Behavior> behaviors;
   
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Appointment> appointment;
    
    @JsonView(Object.class)
    private String status;

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    

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

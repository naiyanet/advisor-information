package th.co.geniustree.intenship.advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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
public class Student extends Account implements Serializable {

    @ManyToOne
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    @JsonView(View.Account.class)
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Advise> advise;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Behavior> behaviors;
  
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Appointment> appointment;

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
    
    
    
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Advise> getAdvise() {
        return advise;
    }

    public void setAdvise(List<Advise> advise) {
        this.advise = advise;
    }

    public List<Behavior> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }


}


package th.co.geniustree.intenship.advisor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Entity
@Table(name = "INFORMATION")
public class Information implements Serializable{
    
    @Id
    @SequenceGenerator(name = "INFORMATION" , sequenceName = "INFORMATION_SEQ",allocationSize=1)
    @GeneratedValue(generator = "INFORMATION",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    private String title;
    private String pageBrief;
    private String description;
    private String linkWeb;
    
    @OneToOne(cascade = CascadeType.ALL)
    private FileUpload fileUpload;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageBrief() {
        return pageBrief;
    }

    public void setPageBrief(String pageBrief) {
        this.pageBrief = pageBrief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }
       
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Information other = (Information) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

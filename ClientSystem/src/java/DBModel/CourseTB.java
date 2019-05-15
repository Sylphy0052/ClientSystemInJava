package DBModel;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CourseTB {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int courseId;
    
    @Column(name = "name")
    private String courseName;
    
    @OneToMany(mappedBy="course", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ClientTB> clientList;
    
    public CourseTB() {}
    
    public CourseTB(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<ClientTB> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientTB> clientList) {
        this.clientList = clientList;
    }

    
}

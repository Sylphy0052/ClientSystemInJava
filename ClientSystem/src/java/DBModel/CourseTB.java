package DBModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class CourseTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int courseId;
    
    @Column(name = "name")
    private String courseName;
    
    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(inverseJoinColumns=@JoinColumn(name="client_id"))
    private List<ClientTB> clientList = new ArrayList<>();
    
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

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int clientId;
    
    @Column(name = "name")
    private String clientName;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "address")
    private String address;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinTable(name="course_id")
    private CourseTB course;
    
    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(inverseJoinColumns=@JoinColumn(name="attend_id"))
    private List<AttendDateTB> attendDate;
    
    public ClientTB() {}
    
    public ClientTB(String name, String gender, String address) {
        this.clientName = name;
        this.gender = gender;
        this.address = address;
        attendDate = new ArrayList<>();
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CourseTB getCourse() {
        return course;
    }

    public void setCourse(CourseTB course) {
        this.course = course;
    }

    public List<AttendDateTB> getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(ArrayList<AttendDateTB> attendDate) {
        this.attendDate = attendDate;
    }
    
    public void setAttendDate(AttendDateTB attendDate) {
        this.attendDate.add(attendDate);
    }
}
package DBModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;
    
    private String name;
    
    private String gender;
    
    private String address;
    
    private String pass;
    
    @ManyToOne(cascade={CascadeType.DETACH})
    private CourseTB course;
    
    @OneToMany(cascade={CascadeType.ALL})
    private List<AttendDateTB> attendDate = new ArrayList<>();
    
    public ClientTB() {}
    
    public ClientTB(String name, String gender, String address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.pass = "test";
    }
    
    public ClientTB(String name, String gender, String address, CourseTB course, AttendDateTB ad) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.course = course;
        this.attendDate.add(ad);
        this.pass = "test";
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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


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
public class UserTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    
    @OneToMany(cascade={CascadeType.ALL})
    private List<DateTB> dateList = new ArrayList<>();
    
    @ManyToOne(cascade={CascadeType.DETACH})
    private CourseTB course;
    
    public UserTB() {}
    
    public UserTB(DateTB d, CourseTB c) {
        dateList.add(d);
        course = c;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<DateTB> getDateList() {
        return dateList;
    }

    public void setDateList(List<DateTB> dateList) {
        this.dateList = dateList;
    }

    public CourseTB getCourse() {
        return course;
    }

    public void setCourse(CourseTB course) {
        this.course = course;
    }
    
}

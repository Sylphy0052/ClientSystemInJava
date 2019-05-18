package DBModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AttendDateTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "date_id")
    private int attendDateId;
    
    @Column(name="attend_date")
    @Temporal(TemporalType.DATE)
    private Date attendDate;

    public AttendDateTB() {}
    
    public AttendDateTB(Date date) {
        this.attendDate = date;
    }

    public int getAttendDateId() {
        return attendDateId;
    }

    public void setAttendDateId(int attendDateId) {
        this.attendDateId = attendDateId;
    }

    public Date getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }
}

package DBModel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttendDateTB {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int attendDateId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "attendDate")
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

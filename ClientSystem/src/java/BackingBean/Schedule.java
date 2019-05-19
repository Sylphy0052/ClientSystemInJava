package BackingBean;

import Controller.DBController;
import DBModel.ClientTB;
import Utils.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class Schedule implements Serializable {
    private List<ScheduleData> todayScheduleList;
    private List<ScheduleData> nextScheduleList;
    private List<ScheduleData> beforeScheduleList;
    private List<ClientTB> clientList;
    
    @EJB
    private DBController dbc;
    
    public Schedule() {}
    
    @PostConstruct
    private void init() {
        this.clientList = dbc.getClientList();
        createScheduleList();
    }
    
    private void createScheduleList() {
        todayScheduleList = new ArrayList<>();
        nextScheduleList = new ArrayList<>();
        beforeScheduleList = new ArrayList<>();
        this.clientList.forEach((client) -> {
            Date todayDate = new Date();
            Date targetDate = client.getAttendDate().get(0).getAttendDate();
            if(Utils.compareDate(todayDate, targetDate) == 0) {
                ScheduleData sd = new ScheduleData(client);
                todayScheduleList.add(sd);
            } else if(Utils.compareDate(todayDate, targetDate) == 1) {
                ScheduleData sd = new ScheduleData(client);
                nextScheduleList.add(sd);
            } else {
                ScheduleData sd = new ScheduleData(client);
                beforeScheduleList.add(sd);
            }
        });
        nextScheduleList.sort((a, b)-> a.getDate().compareTo(b.getDate()));
        beforeScheduleList.sort((a, b)-> b.getDate().compareTo(a.getDate()));
    }

    public List<ScheduleData> getTodayScheduleList() {
        return todayScheduleList;
    }

    public void setTodayScheduleList(List<ScheduleData> todayScheduleList) {
        init();
        this.todayScheduleList = todayScheduleList;
    }

    public List<ScheduleData> getNextScheduleList() {
        return nextScheduleList;
    }

    public void setNextScheduleList(List<ScheduleData> nextScheduleList) {
        this.nextScheduleList = nextScheduleList;
    }

    public List<ScheduleData> getBeforeScheduleList() {
        return beforeScheduleList;
    }

    public void setBeforeScheduleList(List<ScheduleData> beforeScheduleList) {
        this.beforeScheduleList = beforeScheduleList;
    }

    public List<ClientTB> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientTB> clientList) {
        this.clientList = clientList;
    }
    
    public class ScheduleData {
        private String name;
        private String attendDate;
        private Date date;
        private ClientTB client;
        
        public ScheduleData() {}
        
        public ScheduleData(ClientTB client) {
            this.name = client.getName();
            this.date = client.getAttendDate().get(0).getAttendDate();
            this.attendDate = Utils.convertDateFromString(this.date);
            this.client = client;
        }
        
        public ScheduleData(String name, String attendDate, ClientTB client) {
            this.name = name;
            this.attendDate = attendDate;
            this.client = client;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAttendDate() {
            return attendDate;
        }

        public void setAttendDate(String attendDate) {
            this.attendDate = attendDate;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public ClientTB getClient() {
            return client;
        }

        public void setClient(ClientTB client) {
            this.client = client;
        }
    }
}

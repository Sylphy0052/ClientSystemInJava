package BackingBean;

import Controller.DBController;
import DBModel.ClientTB;
import Utils.Utils;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class LoginClient implements Serializable {
    private String name;
    private String pass;
    
    private ClientTB client;
    
    private String message = "";
    
    @EJB
    DBController dbc;
    
    public LoginClient(){}
    
    public String login() {
        try {
            if(checkLogin()) {
                clear();
            }
            return "mypage.xhtml";
        }catch(EJBException e) {
            clear();
            message = "Invalid name or password";
            return null;
        }
    }
    
    public void clear() {
        name = "";
        pass = "";
        message = "";
    }
    
    private boolean checkLogin() {
        this.client = dbc.getClient(name, pass);
        return this.client != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ClientTB getClient() {
        return client;
    }

    public void setClient(ClientTB client) {
        this.client = client;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getAttendDate() {
        Date d = this.client.getAttendDate().get(0).getAttendDate();
        return Utils.convertDateFromString(d);
    }
    
    public String getCourse() {
        return this.client.getCourse().getName();
    }
}

package BackingBean;

import Controller.DBController;
import DBModel.StaffTB;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class LoginStaff {
    private String name;
    private String pass;
    
    private String message = "";
    
    @EJB
    DBController dbc;
    
    public LoginStaff(){}
    
    public String login() {
        try {
            if(dbc.getStaff(name, pass) != null) {
                clear();
            }
            return "main.xhtml";
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
        return dbc.getStaff(name, pass) != null;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

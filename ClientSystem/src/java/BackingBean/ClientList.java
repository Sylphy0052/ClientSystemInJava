package BackingBean;

import Controller.DBController;
import DBModel.ClientTB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class ClientList implements Serializable {
    private List<ClientTB> clientList;
    
    @EJB
    private DBController dbc;
    
    public ClientList() {}

    public List<ClientTB> getClientList() {
        clientList = dbc.getClientList();
        return clientList;
    }

    public void setClientList(List<ClientTB> clientList) {
        this.clientList = clientList;
    }
}

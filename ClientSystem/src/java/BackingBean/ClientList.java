package BackingBean;

import Controller.DBController;
import DBModel.ClientTB;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class ClientList {
    private List<ClientTB> clientList;
    
    @EJB
    private DBController dbc;
    
    public ClientList() {}
    
    public String goToClientList() {
        clientList = dbc.getClients();
        return "client_list.xhtml";
    }

    public List<ClientTB> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientTB> clientList) {
        this.clientList = clientList;
    }
}
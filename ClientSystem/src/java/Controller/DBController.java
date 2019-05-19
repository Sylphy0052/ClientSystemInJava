package Controller;

import DBModel.ClientTB;
import DBModel.CourseTB;
import DBModel.StaffTB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DBController {
    @PersistenceContext
    private EntityManager em;
    
    public DBController() {}
    
    public void add(ClientTB client) {
        em.persist(client);
    }
    
    public void add(CourseTB course) {
        em.persist(course);
    }
    
    public void add(StaffTB staff) {
        em.persist(staff);
    }
    
    public StaffTB getStaff(String name) {
        TypedQuery<StaffTB> query = em.createQuery(
                "SELECT s FROM StaffTB s WHERE s.name = :name",
                StaffTB.class
        );
        return query
                .setParameter("name", name)
                .getSingleResult();
    }
    
    public StaffTB getStaff(String name, String pass) {
        TypedQuery<StaffTB> query = em.createQuery(
                "SELECT s FROM StaffTB s WHERE s.name = :name AND s.pass = :pass",
                StaffTB.class
        );
        return query
                .setParameter("name", name)
                .setParameter("pass", pass)
                .getSingleResult();
    }
    
    public CourseTB getCourse(String course) {
        TypedQuery<CourseTB> query = em.createQuery(
                "SELECT c FROM CourseTB c WHERE c.name = :name", CourseTB.class);
        return query.setParameter("name", course).getSingleResult();
    }
    
    public List<ClientTB> getClientList() {
        return em.createQuery("SELECT c FROM ClientTB c").getResultList();
    }
    
    public List<CourseTB> getCourseList() {
        return em.createQuery("SELECT c FROM CourseTB c").getResultList();
    }
    
    public List<StaffTB> getStaffList() {
        return em.createQuery("SELECT s FROM StaffTB s").getResultList();
    }
    
    public void delete(StaffTB staff) {
        em.remove(em.merge(staff));
    }
    
    public void delete(ClientTB client) {
        em.remove(em.merge(client));
    }
    
}

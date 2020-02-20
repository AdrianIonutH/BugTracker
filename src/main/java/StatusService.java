import org.hibernate.Session;
import org.hibernate.Transaction;

public class StatusService {
    private static StatusService instance;
    private StatusService(){

    }
    public static StatusService getInstance(){
        if (instance == null){
            instance = new StatusService();
        }
        return instance;
    }
    public Status getStatus(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Status statusById = session.find(Status.class, id);
            System.out.println(statusById);
            return statusById;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void createStatus(int itemId, Status createStatus){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(createStatus);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void updateStatus(int id, String updateStatus) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Status statusById = getStatus(id);
            statusById.statusName = updateStatus;
            session.update(statusById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deleteStatus(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Status statusById = getStatus(id);
            session.delete(statusById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}

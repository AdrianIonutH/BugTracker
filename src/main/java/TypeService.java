import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeService {
    private static TypeService instance;
    private TypeService(){

    }
    public static TypeService getInstance(){
        if (instance == null){
            instance = new TypeService();
        }
        return instance;
    }
    public Type getType(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Type typeById = session.find(Type.class, id);
            System.out.println(typeById);
            return typeById;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void createType(int itemId, String createType){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Type type = new Type();
            type.name = createType;
            session.save(type);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void updateType(int id, String updateType) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Type typeById = getType(id);
            typeById.name = updateType;
            session.update(typeById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deleteType(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Type typeById = getType(id);
            session.delete(typeById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}

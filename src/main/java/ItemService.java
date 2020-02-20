import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemService {
    private static ItemService instance;
    private ItemService(){

    }
    public static ItemService getInstance(){
        if (instance == null){
            instance = new ItemService();
        }
        return instance;
    }
    public Item getItem(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Item itemById = session.find(Item.class, id);
            System.out.println(itemById);
            return itemById;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void createItem(int itemId, Item createItem){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(createItem);
            transaction.commit();
            session.close();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void updateItem(int id, String updateItem) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Item itemById = getItem(id);
            itemById.title = updateItem;
            session.update(itemById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deleteItem(int id) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Item itemById = getItem(id);
            session.delete(itemById);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
